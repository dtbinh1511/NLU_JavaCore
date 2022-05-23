package Execise;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
	JRadioButton jrbRed, jrbBlue, jrbYellow;
	JTextArea jta1, jta2, jta3;

	public TrafficLight() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		jrbRed = new JRadioButton("Red");
		jrbBlue = new JRadioButton("Blue");
		jrbYellow = new JRadioButton("Yellow");

		ButtonGroup btg = new ButtonGroup();
		btg.add(jrbRed);
		btg.add(jrbBlue);
		btg.add(jrbYellow);
		// jPanel
		JPanel panel = new JPanel();
		panel.add(new JLabel("Choose one light"));
		panel.add(jrbRed);
		panel.add(jrbBlue);
		panel.add(jrbYellow);
		// jPanel1
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder("Change signal light traffic"));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		jta1 = new JTextArea("-Red", 1, 25);
		jta2 = new JTextArea("-Blue", 1, 25);
		jta3 = new JTextArea("-Yellow", 1, 25);

		jta1.setBackground(null);
		jta1.setEditable(false);
		jta2.setBackground(null);
		jta2.setEditable(false);
		jta3.setBackground(null);
		jta3.setEditable(false);

		panel1.add(jta1);
		panel1.add(jta2);
		panel1.add(jta3);
		// add jFrame
		add(panel1);
		add(panel);

		jrbRed.addActionListener(this);
		jrbBlue.addActionListener(this);
		jrbYellow.addActionListener(this);

		// for jFrame
		pack();
		setTitle("Change Trafic light");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new TrafficLight();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jrbRed) {
			jta1.setText("-Red: Bạn chọn màu đỏ");
			jta2.setText("-Blue");
			jta3.setText("-Yellow");
		}
		if (e.getSource() == jrbBlue) {
			jta2.setText("-Blue: Bạn chọn màu xanh");
			jta1.setText("-Red");
			jta3.setText("-Yellow");
		}
		if (e.getSource() == jrbYellow) {
			jta3.setText("-Yellow: Bạn chọn màu vàng");
			jta2.setText("-Blue");
			jta1.setText("-Red");
		}
	}
}
