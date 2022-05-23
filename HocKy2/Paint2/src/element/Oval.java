package element;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Element2D {

	public Oval(int x1, int y1, int w, int h, Color color) {
		super(x1, y1, w, h, color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawOval(x1, y1, w, h);
	}

}
