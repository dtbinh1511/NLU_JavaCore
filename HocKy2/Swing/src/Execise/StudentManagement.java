package Execise;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentManagement extends JFrame {
	public StudentManagement() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		// jPanel
		JPanel panel = new JPanel();
		add(panel);
		panel.add(new JLabel("Information Student"));
		// jPanel1
		JPanel panel1 = new JPanel();
		add(panel1);

		panel1.add(new JLabel("Full name:"));
		panel1.add(new JTextField(21));

		// jPanel2
		JPanel panel2 = new JPanel();
		add(panel2);

		panel2.add(new JLabel("Date:"));
		panel2.add(new JTextField(2));
		panel2.add(new JTextField(2));
		panel2.add(new JTextField(4));

		// jPanel3
		JPanel panel3 = new JPanel();
		add(panel3);

		panel2.add(new JLabel("Sex:"));
		JRadioButton jrbMale = new JRadioButton("Male");
		JRadioButton jrbFemale = new JRadioButton("Female");
		panel2.add(jrbMale);
		panel2.add(jrbFemale);

		ButtonGroup btg = new ButtonGroup();
		btg.add(jrbMale);
		btg.add(jrbFemale);

		// jPanel4
		JPanel panel4 = new JPanel();
		add(panel4);

		panel4.add(new JLabel("PlaceOfBirth:"));
		panel4.add(new JTextField(8));
		panel4.add(new JLabel("Nationality"));
		panel4.add(new JTextField(8));
		// jPanel5
		JPanel panel5 = new JPanel();
		panel5.setLayout(new BorderLayout());
		add(panel5, BorderLayout.WEST);
		panel5.add(new JLabel("Currently permanent residence:"));
		// jPanel7
		JPanel panel7 = new JPanel();
		add(panel7);
		panel7.add(new JLabel("Number home"));
		panel7.add(new JTextField(10));
		panel7.add(new JLabel("City"));
		panel7.add(new JTextField(10));
		// jPanel6
		JPanel panel6 = new JPanel();
		add(panel6);
		panel6.add(new JLabel("Native village:"));
		panel6.add(new JTextField(10));
		panel6.add(new JLabel("Ethnic:"));
		panel6.add(new JTextField(10));
		// jPanel8
		JPanel panel8 = new JPanel();
		add(panel8);
		panel8.add(new JLabel("Number phone:"));
		panel8.add(new JTextField(10));
		JRadioButton jrbStudent = new JRadioButton("Student");
		JRadioButton jrbSchoolBoy = new JRadioButton("School Boy");
		JRadioButton jrbWork = new JRadioButton("Go to work");

		panel8.add(jrbStudent);
		panel8.add(jrbSchoolBoy);
		panel8.add(jrbWork);
		
		btg.add(jrbStudent);
		btg.add(jrbSchoolBoy);
		btg.add(jrbWork);

		//jPanel9
		JPanel panel9 = new JPanel();
		add(panel9);
		panel9.add(new JButton("Add"));
		panel9.add(new JButton("Cancel"));
		// for jFrame
		pack();
//		setSize(500, 400);
		setTitle("Management Student");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new StudentManagement();
	}

}
