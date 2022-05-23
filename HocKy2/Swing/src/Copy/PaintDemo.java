package Copy;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class PaintDemo extends JFrame {
	public PaintDemo() {
		add(new NewPanel());
		setJFrame();
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new PaintDemo();
	}

	public void setJFrame() {
		setTitle("Test Paint Component");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}

class NewPanel extends JPanel {
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(0, 0, getWidth(), getHeight());
//		g.drawString("Banner here", 0, 40);
		g.drawRect(1, 1, 70, 70);
		g.fillRect(80, 1, 70, 70);

		g.drawRoundRect(0,80,70,80,20,20);
		g.fillRoundRect(80,80,70,80,20,20);
		
		g.drawOval(0, 170, 70, 70);
		g.fillOval(80, 170, 70, 70);
		
		g.draw3DRect(160, 1, 70, 70, true);
		g.fill3DRect(240, 1, 70, 70, false);
		
		g.drawArc(0, 250, 70, 70, 0, 180);
		g.fillArc(80, 250, 70, 70, 0, 180);
		
	}
}
