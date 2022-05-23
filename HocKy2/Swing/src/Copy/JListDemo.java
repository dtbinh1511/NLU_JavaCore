package Copy;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class JListDemo extends JFrame {
	private String[] flagsTitle = { "Vietnam", "Australia", "Canada", "China", "Denmark", "France", "Germany", "Norway",
			"United Kingdoms" };
	private JList list = new JList(flagsTitle);

	public JListDemo() {
		add(new Label("Please choose a country:") , BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		JButton jButton = new JButton("OK");
		
		add(jButton, BorderLayout.SOUTH);
		setSize(400, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JListDemo();
	}

}
