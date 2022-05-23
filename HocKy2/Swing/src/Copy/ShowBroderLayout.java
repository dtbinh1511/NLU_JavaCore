package Copy;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ShowBroderLayout extends JFrame {
	public ShowBroderLayout(String title) {
		super(title);
		setLayout(new BorderLayout(5, 10));
		add(new JButton("West"), BorderLayout.WEST);
		add(new JButton("South"), BorderLayout.SOUTH);
		add(new JButton("North"), BorderLayout.NORTH);
		add(new JButton("East"), BorderLayout.EAST);
		add(new JButton("Center"), BorderLayout.CENTER);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ShowBroderLayout frame = new ShowBroderLayout("Show border layout");
	}

}
