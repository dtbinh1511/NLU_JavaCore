package Execise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestingJComboBox extends JFrame implements ActionListener {
	private String[] bug = { "bug", "bug1", "bug2" };
	private JComboBox cbo = new JComboBox(bug);
	private JLabel label = new JLabel();
	private ImageIcon iUs = new ImageIcon("ImageIcon/us.png");
	private ImageIcon iGermany = new ImageIcon("ImageIcon/germany.png");;

	public TestingJComboBox() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		JPanel panel = new JPanel();
		add(panel);
		panel.add(cbo);
		cbo.addActionListener(this);
		label = new JLabel(iUs);
//		label = new JLabel(iGermany);

		add(label);
		// for jFrame
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TestingJComboBox();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (bug == e.getSource())
			label.setIcon(iUs);
		if (bug == e.getSource())
			label.setIcon(iGermany);
	}

}
