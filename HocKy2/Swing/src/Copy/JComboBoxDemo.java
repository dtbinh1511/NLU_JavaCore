package Copy;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class JComboBoxDemo extends JFrame {
	private String[] flagsTitle = { "Vietnam", "Australia", "Canada", "China", "Denmark", "France", "Germany", "Norway",
			"United Kingdoms" };
	private JComboBox listFlag = new JComboBox(flagsTitle);

	public JComboBoxDemo() {
		add(listFlag, BorderLayout.NORTH);
		
		setSize(400, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JComboBoxDemo();
	}

}
