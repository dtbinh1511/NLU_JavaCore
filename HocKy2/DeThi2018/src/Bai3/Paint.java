package Bai3;

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
	private JButton jbtPoint, jbtLine, jbtRectangle, jbtOval, jbtTriangle,jbtChooseColor, jbtDelete;
	private Color colors[] = { Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.BLACK, Color.ORANGE, Color.PINK,
			Color.GRAY };
	private JPanel panelTool, panelColor;
	JButton[] buttons = new JButton[8];

	private PanelPaint panel;

	public Paint() {
		add(panel = new PanelPaint(this));
		add(createTool(), BorderLayout.NORTH);
		add(createColor(), BorderLayout.SOUTH);
		setJframe();
	}

	public static void main(String[] args) {
		new Paint();
	}

	public void setJframe() {
		setTitle("Paint");
		setSize(1200, 600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public JPanel createTool() {
		panelTool = new JPanel();
		panelTool.add(jbtPoint = setUpButton("Point"));
		panelTool.add(jbtLine = setUpButton("Line"));
		panelTool.add(jbtRectangle = setUpButton("Rectangle"));
		panelTool.add(jbtOval = setUpButton("Oval"));
		panelTool.add(jbtTriangle = setUpButton("Triangle"));
		panelTool.add(jbtChooseColor = setUpButton("Choose Color"));
		panelTool.add(jbtDelete = setUpButton("Delete"));
		return panelTool;
	}

	public JButton setUpButton(String nameButton) {
		JButton button = new JButton(nameButton);
		button.setPreferredSize(new Dimension(120, 30));
		button.addActionListener(this);
		return button;
	}

	public JPanel createColor() {
		panelColor = new JPanel();
		for (int i = 0; i < buttons.length; i++) {
			panelColor.add(buttons[i] = setUpColor(colors[i]));
		}
		return panelColor;
	}

	public JButton setUpColor(Color color) {
		JButton button = new JButton();
		button.setBackground(color);
		button.setPreferredSize(new Dimension(30, 30));
		button.addActionListener(this);
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < buttons.length; i++) {
			if (e.getSource() == buttons[i]) {
				panel.setColor(colors[i]);
			}
		}
		if (e.getSource() == jbtChooseColor) {
			JColorChooser chooser = new JColorChooser();
			Color color = chooser.showDialog(null, "Select Color", null);
			panel.setColor(color);
		}
		if (e.getSource() == jbtDelete) {
			remove(panel);
			add(panel = new PanelPaint(this));
			revalidate();
		}
		if (e.getSource() == jbtLine) {
			panel.setType(Tool.LINE);
		}
		if (e.getSource() == jbtOval) {
			panel.setType(Tool.OVAL);
		}
		if (e.getSource() == jbtPoint) {
			panel.setType(Tool.POINT);
		}
		if (e.getSource() == jbtRectangle) {
			panel.setType(Tool.RECTANGLE);
		}
		if (e.getSource() == jbtTriangle) {
			panel.setType(Tool.TRIANGLE);
		}
	}
}
