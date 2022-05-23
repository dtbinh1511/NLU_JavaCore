package Copy;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelDemo extends JFrame {
	public JPanelDemo() {
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new GridLayout(4, 3));
		for (int i = 1; i <= 9; i++) {
			jPanel1.add(new JButton(" " + i));
		}
		JButton jButton1 = new JButton("0");
		JButton jButton2 = new JButton("Start");
		JButton jButton3 = new JButton("Stop");
		jPanel1.add(jButton1);
		jPanel1.add(jButton2);
		jPanel1.add(jButton3);

		JPanel jPanel2 = new JPanel(new BorderLayout());
		jPanel2.add(new JTextField("Time to be displayed here"),BorderLayout.NORTH);
		
		jPanel2.add(jPanel1,BorderLayout.CENTER);
		
		JButton jbutton = new JButton("Food to be place here");
		add(jbutton, BorderLayout.CENTER);
	
		add(jPanel2,BorderLayout.EAST);//??
		
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JPanelDemo();
	}

}
