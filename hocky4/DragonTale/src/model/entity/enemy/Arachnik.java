package model.entity.enemy;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.entity.Animation;
import model.tileMap.TileMap;

public class Arachnik extends Enemy {
	private BufferedImage[] sprites;
	private double rangeMoveRight;
	private double rangeMoveLeft;

	public Arachnik(TileMap tm, int x, int y) {
		super(tm);
		setPosition(x, y);
		init();
	}
	public void init() {
		rangeMoveRight = x + 25;
		rangeMoveLeft = x - 25;

		moveSpeed = 0.3;
		maxSpeed = 0.3;
//		fallSpeed = 0.2;
//		maxFallSpeed = 10.0;

		width = 30;
		height = 30;
		cwidth = 20;
		cheight = 20;

		health = maxHealth = 5;
		damage = 1;
		// load sprites

		try {
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/Sprites/Enemies/arachnik.gif"));

			sprites = new BufferedImage[1];
			for (int i = 0; i < sprites.length; i++) {
				sprites[i] = spritesheet.getSubimage(i * width, 0, width, height);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		animation = new Animation();
		animation.setFrames(sprites);
		animation.setDelay(300);

		right = true;
		facingRight = true;
		
	}

	private void getNextPosition() {
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
		}
		if (falling) {
			dy += fallSpeed;
		}
	}

	public void update() {
		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);

		// check flinching
		if (flinching) {
			long elapsed = (System.nanoTime() - flinchTimer) / 1000000;
			if (elapsed > 400) {
				flinching = false;
			}
		}
		// if it hit the wall, go other direction
		if (right && x >= rangeMoveRight ) {
			right = false;
			left = true;
			facingRight = false;
		} else if (left && x <= rangeMoveLeft ) {
			right = true;
			left = false;
			facingRight = true;
		}
		// rangeMove
		if (bottomLeft) {

		}

		// update animation
		animation.update();
	}

	public void draw(Graphics2D g) {
//		if (notOnScreen()) {
//			return;
//		}
		setMapPosition();
		super.draw(g);
	}

	
}
