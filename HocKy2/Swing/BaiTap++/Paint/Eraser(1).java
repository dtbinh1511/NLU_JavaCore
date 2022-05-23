package Paint;

import java.awt.Color;
import java.awt.Graphics;

public class Eraser extends Element {

	public Eraser(int x1, int y1) {
		super(x1, y1);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x1, y1, 50, 50);
	}

}
