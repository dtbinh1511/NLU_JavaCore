package Bai3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelPaint extends JPanel {
	public static final Color BACK_GROUND = Color.WHITE;
	public static final int HEIGHT_DRAW = 1000;
	public static final int WIDTH_DRAW = 800;
	private int x1, x2, y1, y2;
	private Element element;
	private Element1D element1d;
	private Element2D element2d;
	private ArrayList<Element> elements = new ArrayList<>();
	private Color color = Color.BLACK;
	private Tool type = Tool.POINT;

	public void setColor(Color color) {
		this.color = color;
	}

	public void setType(Tool tool) {
		this.type = tool;
	}

	public PanelPaint(Paint paint) {
		setBackground(BACK_GROUND);
		setPreferredSize(new Dimension(WIDTH_DRAW, HEIGHT_DRAW));
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
		if (type == Tool.POINT) {
			element1d = new Bai3.Point(x1, y1, x1, y1, color);
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
		if (type == Tool.LINE) {
			element1d.setX2(x2);
			element1d.setY2(y2);
		}
		if (type == Tool.OVAL) {
			element2d.setWidth(Math.abs(x2 - x1));
			element2d.setHeight(Math.abs(y2 - y1));
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

			element2d.setHeight(Math.abs(y2 - y1));
			element2d.setWidth(Math.abs(x2 - x1));
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
