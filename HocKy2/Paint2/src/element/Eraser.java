package element;

import java.awt.Color;
import java.awt.Graphics;

import painting.PaintingPanel;

public class Eraser extends Element {

	public Eraser(int x1, int y1) {
		super(x1, y1);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(PaintingPanel.COLOR_DRAW);
		g.fillRect(x1, y1, 40, 40);
	}

}
