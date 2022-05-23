package Copy;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class RadioButtonDemo extends JFrame {
	public RadioButtonDemo(String title) {
		super(title); // hiện title
		setLayout(new GridLayout(5, 2));
		JLabel jl = new JLabel("Sex:");

		JRadioButton jRadioButton1 = new JRadioButton("Female");
		JRadioButton jRadioButton2 = new JRadioButton("Male");
		JRadioButton jRadioButton3 = new JRadioButton("LGBT");
		// chỉ có 1 lựa chọn
		ButtonGroup btg = new ButtonGroup();
		btg.add(jRadioButton1);
		btg.add(jRadioButton2);
		btg.add(jRadioButton3);

		JButton jButton = new JButton("OK");
		// thêm vào jfame
		add(jl);
		add(jRadioButton1);
		add(jRadioButton2);
		add(jRadioButton3);
		add(jButton);
		// jframe
		pack();
		setSize(300, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new RadioButtonDemo("RandioButton Demo");
	}

}
