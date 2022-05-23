package DeThi2018;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Element1D extends Element {
	protected int x2;
	protected int y2;
	protected Color color;

	public Element1D(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}
	
	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
	}
}
