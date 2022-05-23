package XepHinh;

import javax.swing.JFrame;

public class XepHinh extends JFrame{
	
	public XepHinh() {
		Panel panel = new Panel();
		add(panel);
		setJframe();
	}
	public static void main(String[] args) {
		new XepHinh();
	}
	public void setJframe() {
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
