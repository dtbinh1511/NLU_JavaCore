package Copy;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPasswordFieldDemo extends JFrame {
	public JPasswordFieldDemo(String title) {
		super(title);
		setLayout(new FlowLayout());
		JLabel jLabel1 = new JLabel("Account: ");
		JTextField jTextField = new JTextField(15);
		JLabel jLabel2 = new JLabel("Password:");
		JPasswordField jPasswordField = new JPasswordField(15);
		jPasswordField.setEchoChar('*');// mã hóa ký tự thành *
		JButton jButton = new JButton("OK");
		
		add(jLabel1);
		add(jTextField);
		add(jLabel2);
		add(jPasswordField);
		add(jButton);
		
		pack();
		setSize(300, 150);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JPasswordFieldDemo("JPassword Field Demo");
	}
}
