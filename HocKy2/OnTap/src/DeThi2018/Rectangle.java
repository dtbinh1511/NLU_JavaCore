package DeThi2018;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Element2D {

	public Rectangle(int x1, int y1, int height, int width, Color color) {
		super(x1, y1, height, width, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(x1, y1, getWidth(), getHeight());
	}

}
