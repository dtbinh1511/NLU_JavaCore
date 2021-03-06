package model.state;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import audio.AudioPlayer;
import audio.BackgroundAudio;
import factoryEnemy.FactoryEnemy;
import model.entity.Explosion;
import model.entity.Player;
import model.entity.Teleport;
import model.entity.enemy.Enemy;
import model.tileMap.Background;
import model.tileMap.TileMap;
import observer.DataTime;
import observer.HUD;
import observer.HUD1;
import view.GamePanel;

public class Level1State extends AState implements Observer {
	private String h = "0";
	private String m = "0";
	private String s = "0";
	private TileMap tileMap;
	private Background bg;
	private static int temp = 0;
	private Player player;
	private ArrayList<Enemy> enemies;
	private ArrayList<Explosion> explosions;
	private HUD hud;

	private AudioPlayer bgMusic;

	private Teleport teleport;

	private boolean done;

	public Level1State(GameStateManager gsm, Observable o) {
		this.gsm = gsm;
		o.addObserver(this);
		bgMusic = new BackgroundAudio();
		init();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof DataTime) {
			DataTime data = (DataTime) o;
			this.h = data.getH();
			this.m = data.getM();
			this.s = data.getS();
		}
		updateBg();
	}

	public void init() {
		tileMap = new TileMap(30);

//		bgMusic.play();

//		tileMap.setPosition(0, 0);
		tileMap.setTween(1);

		player = new Player(tileMap);
		player.setPosition(100, 100);
		createEnemies();
		explosions = new ArrayList<Explosion>();

		// register for observer
		hud = new HUD(player);

		// teleport
		teleport = new Teleport(tileMap);
		teleport.setPosition(3150, 197);
	}

	public void updateBg() {
		if (temp != Integer.parseInt(h)) {
			temp = Integer.parseInt(h);
			if (Integer.parseInt(h) >= 5 && Integer.parseInt(h) < 11) {
				bg = new Background("/Backgrounds/background-morning.png", 1);
			} else if (Integer.parseInt(h) >= 11 && Integer.parseInt(h) < 17) {
				bg = new Background("/Backgrounds/background-afternoon.png", 1);
			} else if (Integer.parseInt(h) >= 17 && Integer.parseInt(h) < 23) {
				bg = new Background("/Backgrounds/background-evening.png", 1);
			} else {
				bg = new Background("/Backgrounds/background-night.png", 1);
			}
			bg.setVector(-0.1, 0);
		}
	}

	public void createEnemies() {
		enemies = new ArrayList<Enemy>();
		Enemy s;
		Point[] points = new Point[] { new Point(200, 100), new Point(1213, 80), new Point(1426, 80),
				new Point(1650, 140), new Point(860, 200), new Point(1525, 200), new Point(1680, 200),
				new Point(1800, 200), new Point(2900, 200), new Point(2920, 200), new Point(2940, 200),
				new Point(2030, 110), new Point(3060, 150) };
		for (int i = 0; i < points.length; i++) {
			if (i == points.length - 1) {
				s = FactoryEnemy.get(FactoryEnemy.DRAGON, tileMap, points[i].x, points[i].y);
				enemies.add(s);
			} else if (i == points.length - 2) {
				s = FactoryEnemy.get(FactoryEnemy.BLACKDRAGON, tileMap, points[i].x, points[i].y);
				enemies.add(s);
			} else if (i == 1 || i == 2 || i == 3) {
				s = FactoryEnemy.get(FactoryEnemy.ARACHNIK, tileMap, points[i].x, points[i].y);
				enemies.add(s);
			} else {
				s = FactoryEnemy.get(FactoryEnemy.SLUGGER, tileMap, points[i].x, points[i].y);
				enemies.add(s);
			}
		}
	}

	public void update() {

		if (player.isDead()) {
			gsm.setState(GameStateManager.GAMEOVER);
		}
		if (teleport.contains(player)) {
			gsm.setState(GameStateManager.GAMEWON);
		}
		// update player
		player.update();
		tileMap.setPosition(GamePanel.WIDTH / 2 - player.getX(), GamePanel.HEIGHT / 2 - player.getY());

		// set background
		bg.setPosition(tileMap.getx(), tileMap.gety());

		// check attack to enemies and remove enemies
		checkEnemies();

		for (Enemy e : enemies) {
			e.update();
		}

		// teleport

		if (enemies.size() == 0) {
			done = true;
		}
		teleport.update();

		// restart
		restart();

	}

	public void checkEnemies() {
		// attack enemies
		player.checkAttack(enemies);

		// update all enemies
		for (int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);
			e.update();
			if (e.isDead()) {
				enemies.remove(i);
				i--;
				explosions.add(new Explosion((int) e.getX(), (int) e.getY()));
			}
		}
		for (int i = 0; i < explosions.size(); i++) {
			explosions.get(i).update();
			if (explosions.get(i).shouldRemove()) {
				explosions.remove(i);
				i--;
			}
		}
	}

	public void restart() {
		if (player.getY() >= GamePanel.HEIGHT - 30) {
			player.setPosition(100, 100);
			player.setHealth(player.getHealth() - 1);
			player.setFlinching(true);
			player.setFlinchTimer(System.nanoTime());
		}
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public ArrayList<Explosion> getExplosions() {
		return explosions;
	}

	public void setExplosions(ArrayList<Explosion> explosions) {
		this.explosions = explosions;
	}

	public void draw(Graphics2D g) {
		// draw background
		bg.draw(g);

		// draw tile map
		tileMap.draw(g);

		// draw player
		player.draw(g);

		// draw enemies
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		// draw hud
		hud.draw(g);

		// draw time
		g.drawString(h + ":" + m + ":" + s, 260, 20);

		// draw explosion
		for (int i = 0; i < explosions.size(); i++) {
			explosions.get(i).setMapPosition((int) tileMap.getx(), (int) tileMap.gety());
			explosions.get(i).draw(g);
		}
		// draw teleport
		if (done)
			teleport.draw(g);

	}

	@Override
	public void w(boolean w) {
		player.setJumping(w);
	}

	@Override
	public void e(boolean e) {
		player.setGliding(e);

	}

	@Override
	public void r() {
		player.setScratching();

	}

	@Override
	public void f() {
		player.setFiring();

	}

	@Override
	public void select() {

	}

	@Override
	public void up() {

	}

	@Override
	public void down() {

	}

	@Override
	public void left(boolean left) {
		player.setLeft(left);
	}

	@Override
	public void right(boolean right) {
		player.setRight(right);
	}

}
