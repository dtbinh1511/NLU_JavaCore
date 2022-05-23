package Execise;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrontView extends JFrame {
	private JButton jbt0, jbtStart, jbtStop;

	public FrontView() {
		// jPanel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 3));

		for (int i = 1; i <= 9; i++) {
			JButton jbt = new JButton("" + i);
			panel.add(jbt);
		}
		panel.add(jbt0 = new JButton("0"));
		panel.add(jbt0 = new JButton("Start"));
		panel.add(jbt0 = new JButton("Stop"));

		// jPanel1
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(panel, BorderLayout.CENTER);
		
		JTextField tx = new JTextField("Time to be displayed here");
		panel1.add(tx, BorderLayout.NORTH);

		//jFrame
		add(new JButton("Food to be placed here"),BorderLayout.WEST);
		add(panel1, BorderLayout.EAST);
		
		// for jFrame
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FrontView();
	}

}
