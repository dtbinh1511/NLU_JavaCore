package DeThi2018;

import java.awt.Graphics;

public abstract class Element {
	protected int x1;
	protected int y1;

	public Element(int x1, int y1) {
		super();
		this.x1 = x1;
		this.y1 = y1;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public abstract void draw(Graphics g);
}
