package DeThi2018;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint extends JFrame implements ActionListener {
	private Panel panel;
	private JButton jbtPencil, jbtLine, jbtOval, jbtRect, jbtChooseColor, jbtClear;

	public Paint() {
		add(createTool(), BorderLayout.NORTH);
		add(panel = new Panel(this));

		setJframe();
	}

	public static void main(String[] args) {
		new Paint();
	}

	public void setJframe() {
		setVisible(true);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JButton setUpbutton(String name) {
		JButton button = new JButton(name);
		button.setPreferredSize(new Dimension(120, 30));
		button.addActionListener(this);
		return button;
	}

	public JPanel createTool() {
		JPanel panel = new JPanel();
		panel.add(jbtPencil = setUpbutton("Pencil"));
		panel.add(jbtLine = setUpbutton("Line"));
		panel.add(jbtOval = setUpbutton("Oval"));
		panel.add(jbtRect = setUpbutton("Rectangle"));
		panel.add(jbtChooseColor = setUpbutton("Choose Color"));
		panel.add(jbtClear = setUpbutton("Clear"));
		return panel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtPencil) {
			panel.setType(Tool.PENCIL);
		}
		if (e.getSource() == jbtLine) {
			panel.setType(Tool.LINE);
		}
		if (e.getSource() == jbtOval) {
			panel.setType(Tool.OVAL);
		}
		if (e.getSource() == jbtRect) {
			panel.setType(Tool.RECTANGLE);
		}
		if (e.getSource() == jbtChooseColor) {
			JColorChooser chooser = new JColorChooser();
			Color color = chooser.showDialog(null, "Choose color", null);
			panel.setColor(color);
		}
		if (e.getSource() == jbtClear) {
			remove(panel);
			add( panel = new Panel(this));
			revalidate();
		}
	}
}
