
import java.awt.Color;
import java.awt.Graphics;

public abstract class AShape {
	Point p1, p2;
	Color color;
	
	public AShape(Point p1, Point p2, Color color) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.color = color;
	}
	public abstract void add(Point p);
	public abstract void draw(Graphics g);
	
	

}
