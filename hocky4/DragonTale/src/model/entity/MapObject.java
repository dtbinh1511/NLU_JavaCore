package model.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import model.tileMap.Tile;
import model.tileMap.TileMap;
import view.GamePanel;

public abstract class MapObject {

	// tile stuff
	protected TileMap tileMap;

	public int getCurrentAction() {
		return currentAction;
	}

	public void setCurrentAction(int currentAction) {
		this.currentAction = currentAction;
	}

	protected int tileSize;
	protected double xmap;
	protected double ymap;

	// position and vector
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;

	// dimensions
	protected int width;
	protected int height;

	// collision box
	protected int cwidth;
	protected int cheight;

	// collision
	protected int currRow;
	protected int currCol;
	protected double xdest;
	protected double ydest;
	protected double xtemp;
	protected double ytemp;
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomLeft;
	protected boolean bottomRight;

	// animation
	protected Animation animation;
	protected int currentAction;
	protected int previousAction;
	protected boolean facingRight;

	// movement
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	protected boolean jumping;
	protected boolean falling;

	// movement attributes
	protected double moveSpeed;
	protected double maxSpeed;
	protected double stopSpeed;
	protected double fallSpeed;
	protected double maxFallSpeed;
	protected double jumpStart;
	protected double stopJumpSpeed;

	// constructor
	public MapObject(TileMap tm) {
		tileMap = tm;
		tileSize = tm.getTileSize();
	}

	public boolean intersects(MapObject o) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.intersects(r2);
	}
	
	public void draw(Graphics2D g) {
		if (facingRight) {
			g.drawImage(animation.getImage(), (int) (x + xmap - width / 2), (int) (y + ymap - height / 2), null);
		} else {
			g.drawImage(animation.getImage(), (int) (x + xmap - width / 2 + width), (int) (y + ymap - height / 2),
					-width, height, null);

		}
	}
	
	public void checkTileMapCollision() {

		currCol = (int) x / tileSize;
		currRow = (int) y / tileSize;

		xdest = x + dx;
		ydest = y + dy;

		xtemp = x;
		ytemp = y;

		calculateCorners(x, ydest);
		if (dy < 0) {
			if (topLeft || topRight) {
				dy = 0;
				ytemp = currRow * tileSize + cheight / 2;
			} else {
				ytemp += dy;
			}
		}
		if (dy > 0) {
			if (bottomLeft || bottomRight) {
				dy = 0;
				falling = false;
				ytemp = (currRow + 1) * tileSize - cheight / 2;
			} else {
				ytemp += dy;
			}
		}

		calculateCorners(xdest, y);
		if (dx < 0) {
			if (topLeft || bottomLeft) {
				dx = 0;
				xtemp = currCol * tileSize + cwidth / 2;
			} else {
				xtemp += dx;
			}
		}
		if (dx > 0) {
			if (topRight || bottomRight) {
				dx = 0;
				xtemp = (currCol + 1) * tileSize - cwidth / 2;
			} else {
				xtemp += dx;
			}
		}

		if (!falling) {
			calculateCorners(x, ydest + 1);
			if (!bottomLeft && !bottomRight) {
				falling = true;
			}
		}

	}

	public void calculateCorners(double x, double y) {

		int leftTile = (int) (x - cwidth / 2) / tileSize;
		int rightTile = (int) (x + cwidth / 2 - 1) / tileSize;
		int topTile = (int) (y - cheight / 2) / tileSize;
		int bottomTile = (int) (y + cheight / 2 - 1) / tileSize;

		int tl = tileMap.getType(topTile, leftTile);
		int tr = tileMap.getType(topTile, rightTile);
		int bl = tileMap.getType(bottomTile, leftTile);
		int br = tileMap.getType(bottomTile, rightTile);

		topLeft = tl == Tile.BLOCKED;
		topRight = tr == Tile.BLOCKED;
		bottomLeft = bl == Tile.BLOCKED;
		bottomRight = br == Tile.BLOCKED;

	}
	public Rectangle getRectangle() {
		return new Rectangle((int) x - cwidth, (int) y - cheight, cwidth, cheight);
	}

	public void setX(double x) {
		this.x = x;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getCWidth() {
		return cwidth;
	}

	public int getCHeight() {
		return cheight;
	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(double moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public void setMapPosition() {
		xmap = tileMap.getx();
		ymap = tileMap.gety();
	}

	public void setLeft(boolean b) {
		left = b;
	}

	public void setRight(boolean b) {
		right = b;
	}

	public void setUp(boolean b) {
		up = b;
	}

	public void setDown(boolean b) {
		down = b;
	}

	public void setJumping(boolean b) {
		jumping = b;
	}

	public boolean notOnScreen() {
		return x + xmap + width < 0 || x + xmap - width > GamePanel.WIDTH || y + ymap + height < 0
				|| y + ymap - height > GamePanel.HEIGHT;
	}

	public TileMap getTileMap() {
		return tileMap;
	}

	public void setTileMap(TileMap tileMap) {
		this.tileMap = tileMap;
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public double getXmap() {
		return xmap;
	}

	public void setXmap(double xmap) {
		this.xmap = xmap;
	}

	public double getYmap() {
		return ymap;
	}

	public void setYmap(double ymap) {
		this.ymap = ymap;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public int getCwidth() {
		return cwidth;
	}

	public void setCwidth(int cwidth) {
		this.cwidth = cwidth;
	}

	public int getCheight() {
		return cheight;
	}

	public void setCheight(int cheight) {
		this.cheight = cheight;
	}

	public int getCurrRow() {
		return currRow;
	}

	public void setCurrRow(int currRow) {
		this.currRow = currRow;
	}

	public int getCurrCol() {
		return currCol;
	}

	public void setCurrCol(int currCol) {
		this.currCol = currCol;
	}

	public double getXdest() {
		return xdest;
	}

	public void setXdest(double xdest) {
		this.xdest = xdest;
	}

	public double getYdest() {
		return ydest;
	}

	public void setYdest(double ydest) {
		this.ydest = ydest;
	}

	public double getXtemp() {
		return xtemp;
	}

	public void setXtemp(double xtemp) {
		this.xtemp = xtemp;
	}

	public double getYtemp() {
		return ytemp;
	}

	public void setYtemp(double ytemp) {
		this.ytemp = ytemp;
	}

	public boolean isTopLeft() {
		return topLeft;
	}

	public void setTopLeft(boolean topLeft) {
		this.topLeft = topLeft;
	}

	public boolean isTopRight() {
		return topRight;
	}

	public void setTopRight(boolean topRight) {
		this.topRight = topRight;
	}

	public boolean isBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(boolean bottomLeft) {
		this.bottomLeft = bottomLeft;
	}

	public boolean isBottomRight() {
		return bottomRight;
	}

	public void setBottomRight(boolean bottomRight) {
		this.bottomRight = bottomRight;
	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public int getPreviousAction() {
		return previousAction;
	}

	public void setPreviousAction(int previousAction) {
		this.previousAction = previousAction;
	}

	public boolean isFacingRight() {
		return facingRight;
	}

	public void setFacingRight(boolean facingRight) {
		this.facingRight = facingRight;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public double getStopSpeed() {
		return stopSpeed;
	}

	public void setStopSpeed(double stopSpeed) {
		this.stopSpeed = stopSpeed;
	}

	public double getFallSpeed() {
		return fallSpeed;
	}

	public void setFallSpeed(double fallSpeed) {
		this.fallSpeed = fallSpeed;
	}

	public double getMaxFallSpeed() {
		return maxFallSpeed;
	}

	public void setMaxFallSpeed(double maxFallSpeed) {
		this.maxFallSpeed = maxFallSpeed;
	}

	public double getJumpStart() {
		return jumpStart;
	}

	public void setJumpStart(double jumpStart) {
		this.jumpStart = jumpStart;
	}

	public double getStopJumpSpeed() {
		return stopJumpSpeed;
	}

	public void setStopJumpSpeed(double stopJumpSpeed) {
		this.stopJumpSpeed = stopJumpSpeed;
	}

	public double getX() {
		return x;
	}

	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public boolean contains(MapObject o) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = o.getRectangle();
		return r1.contains(r2);
	}


}
