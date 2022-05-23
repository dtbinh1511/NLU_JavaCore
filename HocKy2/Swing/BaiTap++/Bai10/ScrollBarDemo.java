package Bai10;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class ScrollBarDemo extends JFrame {
	JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL, 50, 30, 0, 200);
	JScrollBar hBar = new JScrollBar(JScrollBar.HORIZONTAL, 40, 20, 0, 200);
	ImageIcon icon = new ImageIcon("ImageIcon/ketthuc.jpg");

	public ScrollBarDemo() {
		add(hBar, BorderLayout.SOUTH);
		add(vbar, BorderLayout.EAST);
		add(new JLabel(icon));

		setFrame();

	}

	public static void main(String[] args) {
		new ScrollBarDemo();
	}

	public void setFrame() {
		setTitle("ScrollBar Demo");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(350, 300);
	}
}
