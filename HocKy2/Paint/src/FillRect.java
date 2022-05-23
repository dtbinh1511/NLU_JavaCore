
import java.awt.Color;
import java.awt.Graphics;

public class FillRect extends AShape {

	public FillRect(Point p1, Point p2, Color color) {
		super(p1, p2, color);
	}

	@Override
	public void add(Point p) {
		p2 = p;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y), Math.abs(p1.x-p2.x), Math.abs(p1.y-p2.y));
	}
	

}
