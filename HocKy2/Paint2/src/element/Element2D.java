package element;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Element2D extends Element {

	protected int w;
	protected int h;
	protected Color color;

	public Element2D(int x1, int y1, int w, int h, Color color) {
		super(x1, y1);
		this.w = w;
		this.h = h;
		this.color = color;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public abstract void draw(Graphics g);

}
