
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

public class Pen extends AShape {
	List<Point> list;

	public Pen(Point p1, Point p2, Color color) {
		super(p1, p2, color);
		list = new ArrayList<>();
	}

	@Override
	public void add(Point p) {
		list.add(p);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		if (list.size() >= 2) {
			Point p1 = list.get(0);
			for (int i = 0; i < list.size(); i++) {
				Point p2 = list.get(i);
				g.drawLine(p1.x, p1.y, p2.x, p2.y);
				p1 = p2;
			}

		}
	}

}
