package Bai16;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUILogin extends JPanel implements ActionListener {
	private JLabel jlUser, jlPasswd, jlConfirm;
	private JTextField txUser = new JTextField(15);
	private JPasswordField txPass = new JPasswordField(15);
	private JPasswordField txConfirm = new JPasswordField(15);
	private JButton jbtLogin, jbtSign;
	String[] user = { "user1" };
	String[] password = { "123" };

	public GUILogin() {
		add(createRow1());
		add(createRow2());
		add(createRow3());
	}

	public JPanel createRow1() {
		JPanel panel = new JPanel();
		panel.add(jlUser = new JLabel("User:"));
		panel.add(txUser);
		return panel;
	}

	public JPanel createRow2() {
		JPanel panel = new JPanel();
		panel.add(jlPasswd = new JLabel("Password:"));
		panel.add(txPass);
		return panel;
	}

	public JPanel createRow3() {
		JPanel panel = new JPanel();
		panel.add(jbtLogin = new JButton("Login"));
		panel.add(jbtSign = new JButton("Sign"));
		jbtLogin.addActionListener(this);
		jbtSign.addActionListener(this);
		return panel;
	}

	public boolean checkPass(char[] input) {
		boolean check = true;
		char[] pass = password[0].toCharArray();
		if (input.length != pass.length) {
			check = false;
		} else {
			check = Arrays.equals(input, pass);
		}
		Arrays.fill(pass, '0');
		return check;
	}

	public JPanel createConfirm() {
		JPanel panel = new JPanel();
		panel.add(jlConfirm = new JLabel("Confirm Password:"));
		panel.add(txConfirm);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtLogin) {
			char[] input = txPass.getPassword();
			if (txUser.getText().equals(user[0]) && checkPass(input) == true) {
				JOptionPane.showMessageDialog(jbtLogin, "Đăng nhập thành công");
			} else {
				JOptionPane.showMessageDialog(jbtLogin, "Sai tài khoản hoặc mật khẩu");
			}
		}
		if (e.getSource() == jbtSign) {
			setJFrameNew();
		}
	}

	public void setJFrameNew() {
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		this.setVisible(false);
		frame.add(createRow1());
		frame.add(createRow2());
		frame.add(createConfirm());
		frame.add(createRow3());
		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
}