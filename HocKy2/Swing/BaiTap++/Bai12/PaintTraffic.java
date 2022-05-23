package Bai12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintTraffic extends JPanel {
	public static final int OVAL = 4;
	private boolean filled = false;
	private int type = 1;
	private Color color;

	public PaintTraffic(int type, Color color) {
		super();
		this.type = type;
		this.color = color;
	}

	public PaintTraffic() {
		super();
	}

	public boolean isFilled() {
		return filled;
	}

	public int getType() {
		return type;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Dimension getPreferredSize() {
		return new Dimension(80, 80);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch (type) {
		case OVAL:
			g.setColor(this.color);
			if (filled)
				g.fillOval(10, 10, 70, 70);
			else
				g.setColor(Color.BLACK);
			g.fillOval(10, 10, 70, 70);
			g.drawOval(10, 10, 70, 70);
			break;
		}
	}
}
