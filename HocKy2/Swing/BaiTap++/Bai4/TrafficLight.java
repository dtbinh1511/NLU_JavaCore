package Bai4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class TrafficLight extends JFrame implements ActionListener {
	JTextArea jta, jtaRed, jtaBlue, jtaYellow;
	JRadioButton jrbRed, jrbBlue, jrbYellow;

	public TrafficLight() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		add(createTrafficLight());
		add(createButton());
		
		//event
		jrbRed.addActionListener(this);
		jrbBlue.addActionListener(this);
		jrbYellow.addActionListener(this);
		// for jframe
		setFrame();

	}

	public static void main(String[] args) {
		new TrafficLight();
	}

	public JPanel createTrafficLight() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(new TitledBorder("Thay đổi tín hiệu đèn giao thông"));
		panel.add(jtaRed = new JTextArea("Red", 1, 25));
		panel.add(jtaBlue = new JTextArea("Blue", 1, 25));
		panel.add(jtaYellow = new JTextArea("Yellow", 1, 25));

		jtaRed.setBackground(null);
		jtaBlue.setBackground(null);
		jtaYellow.setBackground(null);
		jtaRed.setEditable(false);
		jtaBlue.setEditable(false);
		jtaYellow.setEditable(false);

		return panel;
	}

	public JPanel createButton() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Chọn loại đèn"));
		jrbRed = new JRadioButton("Đỏ");
		jrbBlue = new JRadioButton("Xanh");
		jrbYellow = new JRadioButton("Vàng");

		panel.add(jrbRed);
		panel.add(jrbBlue);
		panel.add(jrbYellow);

		ButtonGroup btg = new ButtonGroup();

		btg.add(jrbRed);
		btg.add(jrbBlue);
		btg.add(jrbYellow);
		return panel;
	}

	public void setFrame() {
		setSize(300, 250);
		setTitle("Traffic Light");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jrbBlue) {
			jtaBlue.setText("Blue: Bạn chọn màu xanh");
			jtaRed.setText("Red");
			jtaYellow.setText("Yellow");
		}
		if (e.getSource() == jrbRed) {
			jtaRed.setText("Red: Bạn chọn màu đỏ");
			jtaBlue.setText("Blue");
			jtaYellow.setText("Yellow");
		}
		if (e.getSource() == jrbYellow) {
			jtaYellow.setText("Yellow: Bạn chọn màu vàng");
			jtaRed.setText("Red");
			jtaBlue.setText("Blue");
		}

	}
}
