package Bai5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SaveData extends JFrame implements ActionListener {
	JLabel jlName, jlNnumberMoney;
	JRadioButton jrbMan, jrbWoman;
	JTextField txtName, txtNameShow, txtSexShow, txtMoney, txtMoneyShow;

	public SaveData() {
		this.setLayout(new GridLayout(3, 1, 10, 10));
		add(createRow1());
		add(createRow2());
		add(createRow3());
// event
		txtName.addActionListener(this);
		jrbMan.addActionListener(this);
		jrbWoman.addActionListener(this);
		txtMoney.addActionListener(this);

		// jFrame
		setJFrame();
	}

	public static void main(String[] args) {
		new SaveData();
	}

	public JPanel createRow1() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3, 10, 10));
		panel.add(jlName = new JLabel("Họ tên"));
		panel.add(txtName = new JTextField(15));
		panel.add(txtNameShow = new JTextField(15));
		txtNameShow.setBackground(null);
		txtNameShow.setEditable(false);
		return panel;
	}

	public JPanel createRow2() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3, 10, 10));
		panel.add(jrbMan = new JRadioButton("Nam"));
		panel.add(jrbWoman = new JRadioButton("Nữ"));
		panel.add(txtSexShow = new JTextField(15));
		ButtonGroup btg = new ButtonGroup();
		btg.add(jrbMan);
		btg.add(jrbWoman);
		txtSexShow.setBackground(null);
		txtSexShow.setEditable(false);

		return panel;

	}

	public JPanel createRow3() {
		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(1, 3, 10, 10));
		panel.add(jlNnumberMoney = new JLabel("Số tiền"));
		panel.add(txtMoney = new JTextField(15));
		panel.add(txtMoneyShow = new JTextField(15));

		txtMoneyShow.setBackground(null);
		txtMoneyShow.setEditable(false);
		return panel;
	}

	public void setJFrame() {
		pack();
		setTitle("Khảo sát thông tin");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtName) {
			String s = txtName.getText();
			txtNameShow.setText(s);
		}
		if (e.getSource() == jrbMan) {
			txtSexShow.setText("Nam");
		}
		if (e.getSource() == jrbWoman) {
			txtSexShow.setText("Nữ");
		}
		if (e.getSource() == txtMoney) {
			String s = String.format("%,.2f", Double.parseDouble(txtMoney.getText()));
			txtMoneyShow.setText(s);
		}
	}
}
