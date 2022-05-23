
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	List<AShape> list;
	AShape temp = null;
	Color color;
	String flag = "";
	public PaintPanel() {
		setBackground(Color.WHITE);
		
		list = new ArrayList<>();
		MouseAction ma = new MouseAction(this);
		addMouseListener(ma);
		addMouseMotionListener(ma);
		
		KeyAction key = new KeyAction(this);
		addKeyListener(key);
		setFocusable(true);
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (temp != null)
			temp.draw(g);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).draw(g);
			
		}
		
	}
	
}
