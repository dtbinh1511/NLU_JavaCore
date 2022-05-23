package Copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFigurePanel extends JFrame {
	public TestFigurePanel() {
		setLayout(new GridLayout(2, 3, 5, 5));
		add(new FigurePanel(FigurePanel.LINE));
		add(new FigurePanel(FigurePanel.RECTANGLE));
		add(new FigurePanel(FigurePanel.ROUND_RECTANGLE));
		add(new FigurePanel(FigurePanel.OVAL));
		add(new FigurePanel(FigurePanel.RECTANGLE, true));
		add(new FigurePanel(FigurePanel.ROUND_RECTANGLE, true));
	}

	public static void main(String[] args) {
		TestFigurePanel frame = new TestFigurePanel();
		frame.setSize(400, 400);
		frame.setTitle("TestFigurePanel");
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class FigurePanel extends JPanel {
	public static final int LINE = 1;
	public static final int RECTANGLE = 2;
	public static final int ROUND_RECTANGLE = 3;
	public static final int OVAL = 4;
	private int type = 1;
	private boolean filled = false;

	public FigurePanel() {
	}

	public FigurePanel(int type) {
		this.type = type;
	}

	public FigurePanel(int type, boolean filled) {
		this.type = type;
		this.filled = filled;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Dimension getPreferredSize() {
		return new Dimension(80, 80);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Get the appropriate size for the figure
		int width = getWidth();
		int height = getHeight();
		switch (type) {
		case LINE: // Display two cross lines
			g.setColor(Color.GREEN);
			g.drawLine(10, 10, width - 10, height - 10);
			g.drawLine(width - 10, 10, 10, height - 10);
			break;
		case RECTANGLE: // Display a rectangle
			g.setColor(Color.BLUE);
			if (filled)
				g.fillRect(10, 10, 70, 70);
			else
				g.drawRect(10, 10, 70, 70);
			break;
		case ROUND_RECTANGLE: // Display a round-cornered rectangle
			g.setColor(Color.RED);
			if (filled)
				g.fillRoundRect(10, 10, 70, 70, 20, 20);
			else
				g.drawRoundRect(10, 10, 70, 70, 20, 20);
			break;
		case OVAL:
			g.setColor(Color.YELLOW);
			if (filled)
				g.fillOval(10, 10, 70, 70);
			else
				g.drawOval(10, 10, 70, 70);
		}
	}
}
