package Paint;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Element2D extends Element {
	private int width;
	private int height;
	private Color color;

	public Element2D(int x1, int y1, int width, int height, Color color) {
		super(x1, y1);
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public abstract void draw(Graphics g);

}
