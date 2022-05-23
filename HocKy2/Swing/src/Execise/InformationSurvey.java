package Execise;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class InformationSurvey extends JFrame {
	JTextField txtName, txtShow, txtSexShow, txtMoney, txtMoneyShow;
	Dimension dimText = new Dimension(170, 20);
	Dimension dimSex = new Dimension(105, 20);

	public InformationSurvey() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		// jPanel1
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		add(panel1);

		panel1.add(new JLabel("Họ tên "));
		txtName = new JTextField();
		txtName.setPreferredSize(dimText);
		panel1.add(txtName);

		txtShow = new JTextField();
		txtShow.setPreferredSize(dimText);
		txtShow.setEditable(false);
		panel1.add(txtShow);

		// jPanel2
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());

		add(panel2);
		JRadioButton jrbNam = new JRadioButton("Nam");
		jrbNam.setPreferredSize(dimSex);
		JRadioButton jrbNu = new JRadioButton("Nữ");
		jrbNu.setPreferredSize(dimSex);
		ButtonGroup btg = new ButtonGroup();
		btg.add(jrbNam);
		btg.add(jrbNu);
		panel2.add(jrbNam);
		panel2.add(jrbNu);

		txtSexShow = new JTextField();
		txtSexShow.setPreferredSize(dimText);
		txtSexShow.setEditable(false);
		panel2.add(txtSexShow);
		// jPanel3
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());

		add(panel3);
		panel3.add(new JLabel("Số tiền "));
		txtMoney = new JTextField();
		txtMoney.setPreferredSize(dimText);
		panel3.add(txtMoney);

		txtMoneyShow = new JTextField();
		txtMoneyShow.setPreferredSize(dimText);
		txtMoneyShow.setEditable(false);
		panel3.add(txtMoneyShow);

//for jFrame 
		pack();
		setTitle("Information Survey");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new InformationSurvey();
	}

}
