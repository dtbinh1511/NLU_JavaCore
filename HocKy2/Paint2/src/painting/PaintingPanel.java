package painting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import element.Element;
import element.Element1D;
import element.Element2D;
import element.Eraser;
import element.Line;
import element.Oval;
import element.Pencil;
import element.Rectangle;

public class PaintingPanel extends JPanel {

	public static final int WIDTH_DRAW = 1000;
	public static final int HEIGHT_DRAW = 800;
	public static final Color COLOR_DRAW = Color.WHITE;

	private PaintingFrame paintingFrame;

	private int x1, y1, x2, y2;
	private Element1D element1d;
	private Element2D element2d;
	private Element element;
	private ArrayList<Element> elements = new ArrayList<>();

	private Tool type = Tool.PENCIL;

	private Color clr = Color.BLACK;

	public PaintingPanel(PaintingFrame paintingFrame) {
		setPreferredSize(new Dimension(WIDTH_DRAW, HEIGHT_DRAW));
		setBackground(COLOR_DRAW);

		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}

	public void undo() {
		elements.remove(elements.size() - 1);
	}

	public void setType(Tool tool) {
		this.type = tool;
	}

	public void draw(Graphics g) {
		for (Element element : elements) {
			element.draw(g);
		}
		if (type == Tool.ERASER) {
			g.setColor(Color.RED);
			g.fillRect(x1, y1, 40, 40);
		}
	}

	public void mousePressHandler(MouseEvent e) {
		if (type == Tool.LINE) {
			element1d = new Line(x1, y1, x1, y1, clr);
			elements.add(element1d);
		}

		if (type == Tool.RECTANGLE) {
			element2d = new Rectangle(x1, y1, 0, 0, clr);
			elements.add(element2d);
		}

		if (type == Tool.OVAL) {
			element2d = new Oval(x1, y1, 0, 0, clr);
			elements.add(element2d);
		}
	}

	public void mouseDraggedHandler(MouseEvent e) {
		if (type == Tool.PENCIL) {
			element1d = new Pencil(x1, y1, x2, y2, clr);
			elements.add(element1d);
			x1 = e.getX();
			y1 = e.getY();
		}

		if (type == Tool.LINE) {
			element1d.setX2(x2);
			element1d.setY2(y2);
		}

		if (type == Tool.RECTANGLE) {
			element2d.setW(Math.abs(x2 - x1));
			element2d.setH(Math.abs(y2 - y1));
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

		if (type == Tool.OVAL) {
			element2d.setW(Math.abs(x2 - x1));
			element2d.setH(Math.abs(y2 - y1));
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

		if (type == Tool.ERASER) {
			element = new Eraser(x1, y1);
			elements.add(element);
			x1 = e.getX() - 20;
			y1 = e.getY() - 20;
		}
	}

	public void setColor(Color color) {
		this.clr = color;
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
			mousePressHandler(e);
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
