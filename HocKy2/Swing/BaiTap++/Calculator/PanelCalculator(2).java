package Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextArea;

public class PanelCalculator extends JPanel implements ActionListener {
	// Input
	private String nameBtn[] = { "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "=", "/" };
	private JButton button;
	private JButton jbtSpaceback = new JButton("Spaceback");
	private JButton jbtC = new JButton("C");
	private JButton jbtCE = new JButton("CE");
	// Output
	JTextArea textArea;
	int count = -1;
	// Element number
	private String khungkq;
	String number = "";
	private double num1 = 0;
	private double num2 = 0;
	private double result = 0;
	private int caseNumber = 0;
		
	public PanelCalculator() {
		setPanel();
		KeyAction key = new KeyAction(this);
		textArea.addKeyListener(key);
		setFocusable(true);
	}

	public void setPanel() {
		add(createTextArea(), BorderLayout.NORTH);
		add(createSpecialButton(), BorderLayout.CENTER);
		add(createButton(), BorderLayout.SOUTH);
	}

	// Khởi tạo textArea
	public JTextArea textArea() {
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setText("0");
		return textArea;
	}

	// Add TextArea in panelOutput
	public JPanel createTextArea() {
		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.setPreferredSize(new Dimension(250, 40));
		panel.add(textArea());
		panel.setBackground(Color.WHITE);
		return panel;
	}

	// Tạo các nút
	public JButton button(String namebutton) {
		count++;
		button = new JButton(namebutton);
		button.setBackground(Color.CYAN);
		if ((count + 1) % 4 == 0) {
			button.setForeground(Color.RED);
		} else {
			button.setForeground(Color.BLACK);
		}
		button.addActionListener(this);
		return button;
	}

	public JPanel createButton() {
		JPanel panel = new JPanel();
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(350, 250));
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		panel.setBackground(Color.CYAN);
		for (int i = 0; i < nameBtn.length; i++) {
			panel.add(button(nameBtn[i]));
		}
		return panel;
	}

	public JPanel createSpecialButton() {
		JPanel panel = new JPanel(new FlowLayout());
		JLabel label = new JLabel();
		panel.setPreferredSize(new Dimension(400, 45));
		panel.add(jbtSpaceback);
		panel.add(label);
		panel.add(jbtC);
		panel.add(jbtCE);

		jbtSpaceback.setPreferredSize(new Dimension(175, 40));
		label.setPreferredSize(new Dimension(50, 40));
		jbtC.setPreferredSize(new Dimension(55, 40));
		jbtCE.setPreferredSize(new Dimension(55, 40));
		
		jbtSpaceback.addActionListener(this);
		jbtC.addActionListener(this);
		jbtCE.addActionListener(this);

		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbtC) || e.getSource().equals(jbtCE)) {
			num1 = 0;
			num2 = num1;
			result = num2;
			textArea.setText("");
		}
		if (e.getSource().equals(jbtSpaceback)) {
			khungkq = textArea.getText();
			textArea.setText("");
			for (int i = 0; i < khungkq.length() - 1; i++) {
				textArea.setText( textArea.getText()+ khungkq.charAt(i));
			}
		}
		for (int i = 0; i < nameBtn.length; i++) {
			if ((i + 1) % 4 == 0 || i == 14) {
				continue;
			} else {
				if (e.getActionCommand().equals(nameBtn[i])) {
					textArea.append(nameBtn[i]+"");
				}
			}
		}
		if (e.getActionCommand().equals("+")) {
			caseNumber = 1;
			khungkq = textArea.getText();
			num1 = Double.parseDouble(khungkq);
			textArea.setText("");
		}
		if (e.getActionCommand().equals("-")) {
			caseNumber = 2;
			khungkq = textArea.getText();
			num1 = Double.parseDouble(khungkq);
			textArea.setText("");
		}
		if (e.getActionCommand().equals("*")) {
			caseNumber = 3;
			khungkq = textArea.getText();
			num1 = Double.parseDouble(khungkq);
			textArea.setText("");
		}
		if (e.getActionCommand().equals("/")) {
			caseNumber = 4;
			khungkq = textArea.getText();
			num1 = Double.parseDouble(khungkq);
			textArea.setText("");
		}
		if (e.getActionCommand().equals("=")) {
			khungkq = textArea.getText();
			num2 = Double.parseDouble(khungkq);
			switch (caseNumber) {
			case 1:
				result = num1 + num2;
				textArea.setText(String.valueOf(result));
				break;
			case 2:
				result = num1 - num2;
				textArea.setText(String.valueOf(result));
				break;
			case 3:
				result = num1 * num2;
				textArea.setText(String.valueOf(result));
				break;
			case 4:
				result =  num1 / num2;
				textArea.setText(String.valueOf(result));
				break;
			}
		}
	}
}
