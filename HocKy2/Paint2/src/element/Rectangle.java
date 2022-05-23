package element;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Element2D{
	
	public Rectangle(int x1, int y1, int w, int h, Color color) {
		super(x1, y1, w, h, color);
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawRect(x1, y1, w, h);
	}
	
}
