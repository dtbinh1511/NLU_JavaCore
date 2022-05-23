package Bai8;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class JScrollPaneDemo extends JFrame {
	String[] categories = { "", "Household", "Office", "Extended Family", "Company (US)", "Company (World)", "Team",
			"Will", "Birthday Card List", "High School", "Country", "Continent", "Planet" };
	JList<String> list = new JList<String>(categories);
	JScrollPane jsp;
	JRadioButton jrb;

	public JScrollPaneDemo() {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		add(panel);
		panel.add(createList());
		panel.add(createJrb());
		jsp = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(jsp);
		setFrame();
	}

	public JPanel createList() {
		JPanel panel = new JPanel(new GridLayout(categories.length, 1));
		for (int i = 0; i < categories.length; i++) {
			panel.add(new JLabel(categories[i]));
		}
		return panel;
	}

	public JPanel createJrb() {
		JPanel panel = new JPanel(new GridLayout(categories.length, 3,10,5));
		panel.add(new JLabel("0-1"));
		panel.add(new JLabel("2-5"));
		panel.add(new JLabel("6-10"));
		panel.add(new JLabel("11-15"));
		panel.add(new JLabel("16-20"));
		for (int i = 0; i < (categories.length - 1) * 5; i++) {
			panel.add(jrb = new JRadioButton());
		}
		return panel;
	}

	public static void main(String[] args) {
		new JScrollPaneDemo();
	}

	public void setFrame() {
		setTitle("JScrollPane Demo");
		setSize(350, 250);
//		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
