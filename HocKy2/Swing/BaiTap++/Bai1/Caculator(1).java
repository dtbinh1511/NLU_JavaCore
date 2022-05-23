package Bai1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Caculator extends JFrame implements ActionListener {
	private JButton jbtAdd, jbtSub, jbtMul, jbtDiv, jbtEqual;
	private JTextField txNum1, txNum2, txResult;
	private JLabel lbNum1, lbNum2, lbResult;

	public Caculator() {
		this.setLayout(new GridLayout(5, 1, 5, 5));
		add(createRow1());
		add(createRow2());
		add(createRow3());
		add(createRow4());
		add(createRow5());

		// event
		jbtAdd.addActionListener(this);
		jbtSub.addActionListener(this);
		jbtMul.addActionListener(this);
		jbtDiv.addActionListener(this);
		jbtEqual.addActionListener(this);

		setFrame();

	}

	public static void main(String[] args) {
		new Caculator();
	}

	public JPanel createRow1() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2, 2, 1));
		add(panel);
		panel.add(lbNum1 = new JLabel("Số thứ nhất:"));
		panel.add(txNum1 = new JTextField(10));
		return panel;
	}

	public JPanel createRow2() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 4, 5, 5));
		add(panel);
		panel.add(jbtAdd = new JButton("+"));
		panel.add(jbtSub = new JButton("-"));
		panel.add(jbtMul = new JButton("*"));
		panel.add(jbtDiv = new JButton("/"));

		return panel;
	}

	public JPanel createRow3() {
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(1, 2, 2, 5));
		panel.add(lbNum2 = new JLabel("Số thứ hai"));
		panel.add(txNum2 = new JTextField(10));
		return panel;

	}

	public JPanel createRow4() {
		JPanel panel = new JPanel();
		add(panel);
		panel.add(jbtEqual = new JButton("="));
		return panel;
	}

	public JPanel createRow5() {
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(1, 2, 2, 1));
		panel.add(lbResult = new JLabel("Result"));
		panel.add(txResult = new JTextField(10));
		return panel;
	}

	public void setFrame() {
		pack();
		setTitle("Caculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	double a, b;
	int casenumber;
	double result;

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jbtAdd) {
			a = Double.parseDouble(txNum1.getText());
			casenumber = 1;
		}
		if (e.getSource() == jbtSub) {
			a = Double.parseDouble(txNum1.getText());
			casenumber = 2;
		}
		if (e.getSource() == jbtMul) {
			a = Double.parseDouble(txNum1.getText());
			casenumber = 3;
		}
		if (e.getSource() == jbtDiv) {
			a = Double.parseDouble(txNum1.getText());
			casenumber = 4;
		}
		if (e.getSource() == jbtEqual) {
			try {
				b = Double.parseDouble(txNum2.getText());
				switch (casenumber) {
				case 1:
					result = a + b;
					break;
				case 2:
					result = a - b;
					break;
				case 3:
					result = a * b;
					break;
				case 4:
					result = a / b;
					break;
				}
				txResult.setText(String.valueOf(result));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Nhập vào số");
			}

		}
	}

}