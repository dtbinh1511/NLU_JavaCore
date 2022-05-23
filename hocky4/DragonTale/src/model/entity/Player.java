package model.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import audio.AudioPlayer;
import audio.JumpAudio;
import audio.ScratchAudio;
import model.entity.enemy.Enemy;
import model.tileMap.TileMap;
import observer.Observable;
import observer.Observer;

public class Player extends MapObject implements Observable {

	// player stuff
	private int health;
	private int maxHealth;
	private int fire;
	private int maxFire;
	private boolean dead;
	private boolean flinching;
	private long flinchTimer;

	// fireball
	private boolean firing;
	private int fireCost;
	private int fireBallDamage;
	private ArrayList<FireBall> fireBalls;

	// scratch
	private boolean scratching;
	private int scratchDamage;
	private int scratchRange;

	// gliding
	private boolean gliding;

	// animations
	private ArrayList<BufferedImage[]> sprites;
	private final int[] numFrames = { 2, 8, 1, 2, 4, 2, 5 };

	// animation actions
	public static final int IDLE = 0;
	public static final int WALKING = 1;
	public static final int JUMPING = 2;
	public static final int FALLING = 3;
	public static final int GLIDING = 4;
	public static final int FIREBALL = 5;
	public static final int SCRATCHING = 6;

	private HashMap<String, AudioPlayer> sfx;

	// observer
	private ArrayList<Observer> listObs;

	public Player(TileMap tm) {
		super(tm);

		init();
		listObs = new ArrayList<Observer>();

	}

	public void init() {
		width = 30;
		height = 30;
		cwidth = 20;
		cheight = 20;

		moveSpeed = 0.3;
		maxSpeed = 1.6;
		stopSpeed = 0.4;
		fallSpeed = 0.15;
		maxFallSpeed = 4.0;
		jumpStart = -4.8;
		stopJumpSpeed = 0.3;

		facingRight = true;

		health = maxHealth = 5;
		fire = maxFire = 2500;

		fireCost = 200;
		fireBallDamage = 5;
		fireBalls = new ArrayList<FireBall>();

		scratchDamage = 8;
		scratchRange = 40;

		// load sprites
		try {

			BufferedImage spritesheet = ImageIO
					.read(getClass().getResourceAsStream("/Sprites/Player/playersprites.gif"));

			sprites = new ArrayList<BufferedImage[]>();
			for (int i = 0; i < 7; i++) {

				BufferedImage[] bi = new BufferedImage[numFrames[i]];

				for (int j = 0; j < numFrames[i]; j++) {

					if (i != 6) {
						bi[j] = spritesheet.getSubimage(j * width, i * height, width, height);
					} else {
						bi[j] = spritesheet.getSubimage(j * width * 2, i * height, width * 2, height);
					}

				}

				sprites.add(bi);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		animation = new Animation();
		currentAction = IDLE;
		animation.setFrames(sprites.get(IDLE));
		animation.setDelay(400);

		sfx = new HashMap<String, AudioPlayer>();
		sfx.put("jump", new JumpAudio());
		sfx.put("scratch", new ScratchAudio());
	}

	public ArrayList<FireBall> getFireBalls() {
		return fireBalls;
	}

	public void setFireBalls(ArrayList<FireBall> fireBalls) {
		this.fireBalls = fireBalls;
	}

	public int getHealth() {
		return health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getFire() {
		return fire;
	}

	public int getMaxFire() {
		return maxFire;
	}

	public void setFiring() {
		firing = true;
	}

	public void setScratching() {
		scratching = true;
	}

	public void setGliding(boolean b) {
		gliding = b;
	}

	public void draw(Graphics2D g) {

		setMapPosition();
		// draw fire balls
		for (int i = 0; i < fireBalls.size(); i++) {
			fireBalls.get(i).draw(g);
		}

		// draw player
		if (flinching) {
			long elapsed = (System.nanoTime() - flinchTimer) / 1000000;
			if (elapsed / 100 % 2 == 0) {
				return;
			}
		}

		super.draw(g);

	}

	public boolean isDead() {
		if (health == 0)
			return true;
		return false;

	}

	public void checkAttack(ArrayList<Enemy> enemies) {

		// loop through enemies
		for (int i = 0; i < enemies.size(); i++) {

			Enemy e = enemies.get(i);

			// scratch attack
			if (scratching) {
				if (facingRight) {
					if (e.getX() > x && e.getX() < x + scratchRange && e.getY() > y - height / 2
							&& e.getY() < y + height / 2) {
						e.hit(scratchDamage);
					}
				} else {
					if (e.getX() < x && e.getX() > x - scratchRange && e.getY() > y - height / 2
							&& e.getY() < y + height / 2) {
						e.hit(scratchDamage);
					}
				}
			}

			// fireballs
			for (int j = 0; j < fireBalls.size(); j++) {
				if (fireBalls.get(j).intersects(e)) {
					e.hit(fireBallDamage);
					fireBalls.get(j).setHit();
					break;
				}
			}

			// check enemy collision
			if (intersects(e)) {
				hit(e.getDamage());
			}

		}

	}

	public void hit(int damage) {
		if (flinching)
			return;
		setHealth(getHealth() - damage);
		if (health < 0)
			health = 0;
		if (health == 0)
			dead = true;
		flinching = true;
		flinchTimer = System.nanoTime();
	}

	private void getNextPosition() {

		// movement
		if (left) {
			dx -= moveSpeed;
			if (dx < -maxSpeed) {
				dx = -maxSpeed;
			}
		} else if (right) {
			dx += moveSpeed;
			if (dx > maxSpeed) {
				dx = maxSpeed;
			}
		} else {
			if (dx > 0) {
				dx -= stopSpeed;
				if (dx < 0) {
					dx = 0;
				}
			} else if (dx < 0) {
				dx += stopSpeed;
				if (dx > 0) {
					dx = 0;
				}
			}
		}

		// cannot move while attacking, except in air
		if ((currentAction == SCRATCHING || currentAction == FIREBALL) && !(jumping || falling)) {
			dx = 0;
		}

		// jumping
		if (jumping && !falling) {
			sfx.get("jump").play();
			dy = jumpStart;
			falling = true;
		}

		// falling
		if (falling) {

			if (dy > 0 && gliding)
				dy += fallSpeed * 0.1;
			else
				dy += fallSpeed;

			if (dy > 0)
				jumping = false;
			if (dy < 0 && !jumping)
				dy += stopJumpSpeed;

			if (dy > maxFallSpeed)
				dy = maxFallSpeed;

		}

	}

	public void update() {

		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);

		// check attack has stopped
		if (currentAction == SCRATCHING) {
			if (animation.hasPlayedOnce())
				scratching = false;
		}
		if (currentAction == FIREBALL) {
			if (animation.hasPlayedOnce())
				firing = false;
		}

		// fireball attack
		setFire(getFire() + 1);
		if (firing && currentAction != FIREBALL) {
			if (fire > fireCost) {
				setFire(getFire() - fireCost);
				FireBall fb = new FireBall(tileMap, facingRight);
				fb.setPosition(x, y);
				fireBalls.add(fb);
			}
		}

		// update fireballs
		for (int i = 0; i < fireBalls.size(); i++) {
			fireBalls.get(i).update();
			if (fireBalls.get(i).shouldRemove()) {
				fireBalls.remove(i);
				i--;
			}
		}

		// check done flinching
		if (flinching) {
			long elapsed = (System.nanoTime() - flinchTimer) / 1000000;
			if (elapsed > 1000) {
				flinching = false;
			}
		}

		// set animation
		if (scratching) {
			if (currentAction != SCRATCHING) {
				sfx.get("scratch").play();
				currentAction = SCRATCHING;
				animation.setFrames(sprites.get(SCRATCHING));
				animation.setDelay(50);
				width = 60;
			}
		} else if (firing) {
			if (currentAction != FIREBALL) {
				currentAction = FIREBALL;
				animation.setFrames(sprites.get(FIREBALL));
				animation.setDelay(100);
				width = 30;
			}
		} else if (dy > 0) {
			if (gliding) {
				if (currentAction != GLIDING) {
					currentAction = GLIDING;
					animation.setFrames(sprites.get(GLIDING));
					animation.setDelay(100);
					width = 30;
				}
			} else if (currentAction != FALLING) {
				currentAction = FALLING;
				animation.setFrames(sprites.get(FALLING));
				animation.setDelay(100);
				width = 30;
			}
		} else if (dy < 0) {
			if (currentAction != JUMPING) {
				currentAction = JUMPING;
				sfx.get("jump").play();
				animation.setFrames(sprites.get(JUMPING));
				animation.setDelay(-1);
				width = 30;
			}
		} else if (left || right) {
			if (currentAction != WALKING) {
				currentAction = WALKING;
				animation.setFrames(sprites.get(WALKING));
				animation.setDelay(40);
				width = 30;
			}
		} else {
			if (currentAction != IDLE) {
				currentAction = IDLE;
				animation.setFrames(sprites.get(IDLE));
				animation.setDelay(400);
				width = 30;
			}
		}

		animation.update();

		// set direction
		if (currentAction != SCRATCHING && currentAction != FIREBALL) {
			if (right)
				facingRight = true;
			if (left)
				facingRight = false;
		}

	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public boolean isFlinching() {
		return flinching;
	}

	public void setFlinching(boolean flinching) {
		this.flinching = flinching;
	}

	public long getFlinchTimer() {
		return flinchTimer;
	}

	public void setFlinchTimer(long flinchTimer) {
		this.flinchTimer = flinchTimer;
	}

	public boolean isFiring() {
		return firing;
	}

	public void setFiring(boolean firing) {
		this.firing = firing;
	}

	public int getFireCost() {
		return fireCost;
	}

	public void setFireCost(int fireCost) {
		this.fireCost = fireCost;
	}

	public int getFireBallDamage() {
		return fireBallDamage;
	}

	public void setFireBallDamage(int fireBallDamage) {
		this.fireBallDamage = fireBallDamage;
	}

	public boolean isScratching() {
		return scratching;
	}

	public void setScratching(boolean scratching) {
		this.scratching = scratching;
	}

	public int getScratchDamage() {
		return scratchDamage;
	}

	public void setScratchDamage(int scratchDamage) {
		this.scratchDamage = scratchDamage;
	}

	public int getScratchRange() {
		return scratchRange;
	}

	public void setScratchRange(int scratchRange) {
		this.scratchRange = scratchRange;
	}

	public ArrayList<BufferedImage[]> getSprites() {
		return sprites;
	}

	public void setSprites(ArrayList<BufferedImage[]> sprites) {
		this.sprites = sprites;
	}

	public boolean isGliding() {
		return gliding;
	}

	public int[] getNumFrames() {
		return numFrames;
	}

	public void setHealth(int health) {
		this.health = health;
		notifyObserver();
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void setFire(int fire) {
		if (this.fire != fire && fire <= maxFire) {
			this.fire = fire;
			notifyObserver();
		}
	}

	public void setMaxFire(int maxFire) {
		this.maxFire = maxFire;
	}

	@Override
	public void addObserver(Observer obs) {
		listObs.add(obs);

	}

	@Override
	public void deleteObserver(Observer obs) {
		listObs.remove(obs);

	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < listObs.size(); i++) {
			listObs.get(i).update(this);
		}

	}
}
