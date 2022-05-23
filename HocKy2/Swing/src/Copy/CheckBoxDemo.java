package Copy;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxDemo extends JFrame {
	public CheckBoxDemo(String title) {
		super(title);
		setLayout(new GridLayout(5, 2));
		JLabel jLabel = new JLabel("Your hobbies:");

		JCheckBox jCheckBox1 = new JCheckBox("Watching movie");
		JCheckBox jCheckBox2 = new JCheckBox("Listening to music");
		JCheckBox jCheckBox3 = new JCheckBox("Reading book");
		JButton jButton = new JButton("OK");
		add(jLabel);
		add(jCheckBox1);
		add(jCheckBox2);
		add(jCheckBox3);
		add(jButton);
		pack();
		setSize(300, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new CheckBoxDemo("Check box Demo");

	}

}
