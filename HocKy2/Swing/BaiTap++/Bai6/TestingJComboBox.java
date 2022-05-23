package Bai6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestingJComboBox extends JFrame implements ActionListener {
	String[] flags = { "us", "norway", "canada" };
	JComboBox<String> jcbFlag = new JComboBox<String>(flags);
	ImageIcon iUS, iNorway, iCanada;
	JLabel jlShow;

	public TestingJComboBox() {

		add(jcbFlag, BorderLayout.NORTH);
		add(jlShow = new JLabel());
		// xử lý sự kiện

		jcbFlag.addActionListener(this);
		// jFrame
		setJFrame();

	}

	public static void main(String[] args) {
		new TestingJComboBox();
	}

	public void setJFrame() {
		setTitle("Testing JComboBox");
		setSize(400, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nameFlag = flags[jcbFlag.getSelectedIndex()];
		ImageIcon flag = new ImageIcon("ImageIcon/" + nameFlag + ".png");
		jlShow.setIcon(flag);

	}
}
