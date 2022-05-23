package Bai3;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Element2D extends Element {
	protected int height;
	protected int width;
	protected Color color;

	public Element2D(int x1, int y1, int height, int width, Color color) {
		super(x1, y1);
		this.height = height;
		this.width = width;
		this.color = color;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public abstract void draw(Graphics g);
}
