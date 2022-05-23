package DeThi2018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel {
	private Tool type = Tool.PENCIL;
	private Color color = Color.BLACK;

	public void setType(Tool type) {
		this.type = type;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	//
	private Element element;
	private Element1D element1d;
	private Element2D element2d;
	private ArrayList<Element> elements = new ArrayList<Element>();
	int x1, x2, y1, y2;

	public Panel(Paint paint) {
		setBackground(Color.WHITE);
		setSize(1000, 700);
		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}

	public void draw(Graphics g) {
		for (Element element : elements) {
			element.draw(g);
		}
	}

	public void mousePressedHandler(MouseEvent e) {
		if (type == Tool.LINE) {
			element1d = new Line(x1, y1, x1, y1, color);
			elements.add(element1d);
		}
		if (type == Tool.OVAL) {
			element2d = new Oval(x1, y1, 0, 0, color);
			elements.add(element2d);
		}
		if (type == Tool.RECTANGLE) {
			element2d = new Rectangle(x1, y1, 0, 0, color);
			elements.add(element2d);
		}
	}

	public void mouseDraggedHandler(MouseEvent e) {
		if (type == Tool.PENCIL) {
			element1d = new Pencil(x1, y1, x2, y2, color);
			elements.add(element1d);
			x1 = e.getX();
			y1 = e.getY();
		}
		if (type == Tool.LINE) {
			element1d.setX1(x2);
			element1d.setY1(y2);
		}
		if (type == Tool.OVAL) {
			element2d.setHeight(Math.abs(y1 - y2));
			element2d.setWidth(Math.abs(x1 - x2));
			if (x1 < x2 && y1 > y2) {
				element2d.setX1(x1);
				element2d.setY1(y2);
			}
			if (x1 > x2 && y1 > y2) {
				element2d.setX1(x2);
				element2d.setY1(y2);
			}
			if (x1 > x2 && y1 < y2) {
				element2d.setX1(x2);
				element2d.setY1(y1);
			}
		}
		if (type == Tool.RECTANGLE) {
			element2d.setHeight(Math.abs(y1 - y2));
			element2d.setWidth(Math.abs(x1 - x2));
			if (x1 < x2 && y1 > y2) {
				element2d.setX1(x1);
				element2d.setY1(y2);
			}
			if (x1 > x2 && y1 > y2) {
				element2d.setX1(x2);
				element2d.setY1(y2);
			}
			if (x1 > x2 && y1 < y2) {
				element2d.setX1(x2);
				element2d.setY1(y1);
			}
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	class MouseHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			x1 = e.getX();
			y1 = e.getY();
			mousePressedHandler(e);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			super.mouseDragged(e);
			x2 = e.getX();
			y2 = e.getY();
			mouseDraggedHandler(e);
			repaint();
		}
	}
}
