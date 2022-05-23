
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAction extends MouseAdapter{
	PaintPanel pp;
	AShape aShape;
	
	public MouseAction(PaintPanel pp) {
		super();
		this.pp = pp;
	}
	
	//Lấy sự kiện nhấn
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		aShape = getAShape(pp.flag, new Point(e.getX(), e.getY()), null);
	}
	
	// Lấy sự kiện nhả
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		aShape.add(new Point(e.getX(),e.getY()));
		pp.list.add(aShape);
		pp.temp = null;
		pp.repaint();
	}
	
	// Lấy sự kiện kéo chuột
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		aShape.add(new Point(e.getX(), e.getY()));
		pp.temp = aShape;
		pp.repaint();
	}
	public AShape getAShape(String flag, Point p1, Point p2) {
		switch (flag) {
		case "Line":
			aShape = new Line(p1, p2, pp.color);
			break;
		case "Rec":
			aShape = new Rectangle(p1, p2, pp.color);
			break;
		case "Pen":
			aShape = new Pen(p1, p2, pp.color);
			break;
		case "Circle":
			aShape = new Circle(p1, p2, pp.color);
			break;
		case "FillOval":
			aShape = new FillOval(p1, p2, pp.color);
			break;
		case "FillRect":
			aShape = new FillRect(p1, p2, pp.color);
			break;
			
		default:
			break;
			
		}
		return aShape;
	}
	
}
