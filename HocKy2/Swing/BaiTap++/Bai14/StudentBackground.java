package Bai14;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentBackground extends JPanel implements ActionListener {
	ArrayList<Student> listStu = new ArrayList<Student>();

	JLabel jlTitle, jlName, jlDate, jlSex, jlFavorite;
	JCheckBox checkBoxFood = new JCheckBox("Ăn uống");
	JCheckBox checkBoxShop = new JCheckBox("Mua sắm");
	JCheckBox checkBoxSing = new JCheckBox("Ca hát");
	JCheckBox checkBoxTravel = new JCheckBox("Du lịch");
	String day[] = new String[31];
	String month[] = new String[12];
	String year[] = new String[81];
	JComboBox<String> comboBoxDay;
	JComboBox<String> comboBoxMonth;
	JComboBox<String> comboBoxYear;
	JRadioButton jrbMale = new JRadioButton("Nam");
	JRadioButton jrbFemale = new JRadioButton("Nữ");
	JTextField txName = new JTextField(20);
	JTextArea jta = new JTextArea();
	Dimension dim = new Dimension(200, 30);
	Dimension dimButton = new Dimension(200, 100);

	JButton jbtSave, jbtOpen, jbtExit, jbtArrange;

	public StudentBackground() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(createTitle());
		add(createName());
		add(createDate());
		add(createSex());
		add(createFavorite());
		add(createButton());
		add(new JScrollPane(createList()));
		setPreferredSize(dim);
	}

	public JPanel createTitle() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(jlTitle = new JLabel("LÝ LỊCH SINH VIÊN"));
		return panel;
	}

	public JPanel createName() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(dim);
		panel.add(jlName = new JLabel("Họ và tên:"));
		panel.add(txName);
		panel.setPreferredSize(dim);
		return panel;
	}

	public JPanel createDate() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(dim);
		for (int i = 1; i <= 31; i++) {
			day[i - 1] = i + "";
		}
		for (int i = 1; i <= 12; i++) {
			month[i - 1] = i + "";
		}
		for (int i = 1940; i <= 2020; i++) {
			year[i - 1940] = i + "";
		}
		panel.add(jlDate = new JLabel("Ngày sinh:"));
		panel.add(comboBoxDay = new JComboBox<String>(day));
		panel.add(comboBoxMonth = new JComboBox<String>(month));
		panel.add(comboBoxYear = new JComboBox<String>(year));
		return panel;
	}

	public JPanel createSex() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(dim);
		panel.add(jlSex = new JLabel("Giới tính:"));
		panel.add(jrbMale);
		panel.add(jrbFemale);

		ButtonGroup btg = new ButtonGroup();
		btg.add(jrbMale);
		btg.add(jrbFemale);
		return panel;
	}

	public JPanel createFavorite() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(dim);
		panel.setLayout(new FlowLayout());
		JPanel panel1 = new JPanel();
		panel.add(panel1);
		panel1.add(jlFavorite = new JLabel("Sở thích:"));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 2));
		panel.add(panel2);
		panel2.add(checkBoxFood);
		panel2.add(checkBoxSing);
		panel2.add(checkBoxShop);
		panel2.add(checkBoxTravel);
		return panel;
	}

	public JPanel createButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(dim);
		panel.add(jbtSave = new JButton("Save"));
		panel.add(jbtOpen = new JButton("Open"));
		panel.add(jbtArrange = new JButton("Arrange"));
		panel.add(jbtExit = new JButton("Exit"));
		// event
		jbtSave.addActionListener(this);
		jbtOpen.addActionListener(this);
		jbtArrange.addActionListener(this);
		jbtExit.addActionListener(this);

		return panel;
	}

	public JPanel createList() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Thông tin sinh viên"));
		panel.add(jta, new BorderLayout(0, 0));

		jta.setSize(300, 20);
		jta.setEnabled(false);
		return panel;
	}

	public String sex() {
		String s = "";
		if (jrbFemale.isSelected() == true) {
			s = "Nữ" + "";
		}
		if (jrbMale.isSelected() == true) {
			s = "Nam" + "";
		}
		return s;
	}

	public String favorite() {
		String s = "";
		if (checkBoxFood.isSelected() == true) {
			s = "Đồ uống" + "";
		}
		if (checkBoxShop.isSelected() == true) {
			s = "Mua sắm" + "";
		}
		if (checkBoxTravel.isSelected() == true) {
			s = "Du lịch" + "";
		}
		if (checkBoxSing.isSelected() == true) {
			s = "Ca hát" + "";
		}
		return s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbtSave) || e.getActionCommand().equals("Save")) {
			if (txName.getText().equals("")) {
				JOptionPane.showMessageDialog(jbtSave, "Bạn chưa nhập tên");
			} else {
				Student st = new Student(txName.getText(), sex(),
						new Date(Integer.parseInt(day[comboBoxDay.getSelectedIndex()]),
								Integer.parseInt(month[comboBoxMonth.getSelectedIndex()]),
								Integer.parseInt(year[comboBoxYear.getSelectedIndex()])),
						favorite());
				listStu.add(st);

				txName.setText("");
				checkBoxFood.setSelected(false);
				checkBoxShop.setSelected(false);
				checkBoxSing.setSelected(false);
				checkBoxTravel.setSelected(false);
			}
		}

		if (e.getSource() == jbtOpen) {
			jta.setText("");
			for (int j = 0; j < listStu.size(); j++) {
				jta.append((j + 1) + "-" + listStu.get(j).getName() + "\t" + listStu.get(j).getSex() + "\t"
						+ listStu.get(j).getDate() + "\t" + listStu.get(j).getFavorite() + "\n");
			}
		}
		if (e.getSource() == jbtArrange) {
			Collections.sort(listStu, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					return o1.getName().compareToIgnoreCase(o2.getName());
				}
			});
			jta.setText("");
			for (int j = 0; j < listStu.size(); j++) {
				jta.append((j + 1) + "-" + listStu.get(j).getName() + "\t" + listStu.get(j).getSex() + "\t"
						+ listStu.get(j).getDate() + "\t" + listStu.get(j).getFavorite() + "\n");
			}
		}
		if (e.getSource() == jbtExit) {
			System.exit(0);
		}
	}

}
