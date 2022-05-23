package Bai12;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TrafficLight2 extends JFrame implements ActionListener {
	ImageIcon iGray;
	JLabel jlRed, jlGreen, jlYellow;
	JRadioButton jrbRed, jrbGreen, jrbYellow;

	public TrafficLight2() {
		this.setLayout(new GridLayout(2, 1));
		add(createImage());
		add(createRadioButton());
		// event
		jrbRed.addActionListener(this);
		jrbGreen.addActionListener(this);
		jrbYellow.addActionListener(this);

		// jframe
		setJFrame();
	}

	public static void main(String[] args) {
		new TrafficLight2();
	}

	public JPanel createRadioButton() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Chọn loại đèn:"));
		panel.add(jrbRed = new JRadioButton("Đỏ"));
		panel.add(jrbGreen = new JRadioButton("Xanh"));
		panel.add(jrbYellow = new JRadioButton("Vàng"));

		ButtonGroup btg = new ButtonGroup();
		btg.add(jrbRed);
		btg.add(jrbGreen);
		btg.add(jrbYellow);

		return panel;
	}

	public JPanel createImage() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3, 5, 5));
		iGray = new ImageIcon("ImageIcon/gray.png");
		panel.add(jlRed = new JLabel(iGray));
		panel.add(jlGreen = new JLabel(iGray));
		panel.add(jlYellow = new JLabel(iGray));

		return panel;
	}

	public void setJFrame() {
		setTitle("Traffic Light");
		setSize(400, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jrbRed) {
			jlRed.setIcon(new ImageIcon("ImageIcon/red.png"));
			jlGreen.setIcon(new ImageIcon("ImageIcon/gray.png"));
			jlYellow.setIcon(new ImageIcon("ImageIcon/gray.png"));
		}
		if (e.getSource() == jrbGreen) {
			jlGreen.setIcon(new ImageIcon("ImageIcon/green.png"));
			jlRed.setIcon(new ImageIcon("ImageIcon/gray.png"));
			jlYellow.setIcon(new ImageIcon("ImageIcon/gray.png"));
		}
		if (e.getSource() == jrbYellow) {
			jlYellow.setIcon(new ImageIcon("ImageIcon/yellow.png"));
			jlRed.setIcon(new ImageIcon("ImageIcon/gray.png"));
			jlGreen.setIcon(new ImageIcon("ImageIcon/gray.png"));
		}
	}
}
