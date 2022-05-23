package Bai3;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Element2D {

	public Oval(int x1, int y1, int height, int width, Color color) {
		super(x1, y1, height, width, color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(x1, y1, getWidth(), getHeight());
	}

}
