
import java.awt.Color;
import java.awt.Graphics;

public class Line extends AShape {
	
	public Line (Point p1, Point p2, Color color) {
		super(p1, p2, color);
	}

	@Override
	public void add(Point p) {
		p2 = p;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}


}
