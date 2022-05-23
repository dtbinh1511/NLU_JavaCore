package Copy;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestButtonICon extends JFrame {
	public TestButtonICon() {
		ImageIcon iUS = new ImageIcon("ImageIcon/us.png");
		ImageIcon iCa = new ImageIcon("ImageIcon/canada.png");
		ImageIcon iGer = new ImageIcon("ImageIcon/germany.png");

		JButton jbtClick = new JButton("Click it", iUS);

		jbtClick.setPressedIcon(iCa); // nhấn giữ sẽ hiện
		jbtClick.setRolloverIcon(iGer);// con chuột nằm trên jframe sẽ hiện
		add(jbtClick); // add button in jframe

	}

	public static void main(String[] args) {
		TestButtonICon buttonIcon = new TestButtonICon();
		buttonIcon.setTitle("Button Demo");
		buttonIcon.setSize(300, 300);
		buttonIcon.setLocationRelativeTo(null);
		buttonIcon.setVisible(true);
		buttonIcon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
