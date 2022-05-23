package Copy;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class JTextAreaDemo extends JFrame {
	public JTextAreaDemo(String title) {
		super(title);
		setLayout(new FlowLayout());
		JLabel jLabel = new JLabel("Description");
		JTextArea jTextAreaDemo = new JTextArea("This is a textarea\nYou can input data in muti line", 5, 20);

		add(jLabel);
		add(jTextAreaDemo);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new JTextAreaDemo("JTextArea Demo");
	}

}
