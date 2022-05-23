package Copy;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class ScrossBarDemo extends JFrame {
	public ScrossBarDemo(String title) {
		super(title);

		JScrollBar hBar = new JScrollBar(JScrollBar.HORIZONTAL,20,30,0,100);
		JScrollBar vBar = new JScrollBar(JScrollBar.VERTICAL,30,40,0,100);
		
		add(hBar,BorderLayout.SOUTH);
		add(vBar,BorderLayout.EAST);
		add(new JLabel(new ImageIcon("ImageIcon/cache1.png")), BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new ScrossBarDemo("Scross Bar Demo");
	}

}
