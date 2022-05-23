package Copy;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JTextFieldDemo extends JFrame {
	public JTextFieldDemo(String title) {
		super(title);
		setLayout(new FlowLayout());
		JLabel jLabel = new JLabel("Sample TextField");
		JTextField jTextField = new JTextField(20);

		add(jLabel);
		add(jTextField);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTextFieldDemo("JTextField Demo");
	}

}
