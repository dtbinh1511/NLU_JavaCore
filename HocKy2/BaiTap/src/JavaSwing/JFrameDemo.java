package JavaSwing;

import javax.swing.JButton;

public class JFrameDemo {
	private JFrame frame;
	JButton button;

	public JFrameDemo() {
		createAndShow();
	}

	public void createAndShow() {
		frame = new JFrame("Tille");
		frame.setSize(400, 300);
		frame.setVisible(true);
	}

}
