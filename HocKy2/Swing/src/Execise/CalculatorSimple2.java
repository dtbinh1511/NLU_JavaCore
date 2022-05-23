package Execise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class CalculatorSimple2 extends JFrame implements ActionListener {
	private JLabel jlNumber1, jlNumber2, jlResult;
	private JRadioButton jrbAdd, jrbSub, jrbMul, jrbDiv;
	private JTextField txNumber1, txNumber2, txResult;

	public CalculatorSimple2() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		add(createRow1());
		add(createRow2());
		add(createButton());
		add(createResult());
		setJFrame();
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new CalculatorSimple2();
	}

	public JPanel createRow1() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		panel.add(jlNumber1 = new JLabel("Number 1:"));
		panel.add(txNumber1 = new JTextField(15));

		return panel;
	}

	public JPanel createRow2() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(jlNumber2 = new JLabel("Number 2:"));
		panel.add(txNumber2 = new JTextField(15));
		return panel;
	}

	public JPanel createButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(jrbAdd = new JRadioButton("+"));
		panel.add(jrbSub = new JRadioButton("-"));
		panel.add(jrbMul = new JRadioButton("*"));
		panel.add(jrbDiv = new JRadioButton("/"));
		// button group
		ButtonGroup btg = new ButtonGroup();
		btg.add(jrbAdd);
		btg.add(jrbSub);
		btg.add(jrbDiv);
		btg.add(jrbMul);

		// event
		jrbAdd.addActionListener(this);
		jrbSub.addActionListener(this);
		jrbMul.addActionListener(this);
		jrbDiv.addActionListener(this);

		return panel;
	}

	public JPanel createResult() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(jlResult = new JLabel("Result:"));
		panel.add(txResult = new JTextField(15));
		txResult.setEnabled(false);
		return panel;
	}

	public void setJFrame() {
		setSize(300, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	double num1, num2;
	double result;
	int caseNumber;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (jrbAdd.isSelected() == true) {
			num1 = Double.parseDouble(txNumber1.getText());
			num2 = Double.parseDouble(txNumber2.getText());
			txResult.setText(String.valueOf(num1 + num2));
		}
		if (jrbSub.isSelected() == true) {
			num1 = Double.parseDouble(txNumber1.getText());
			num2 = Double.parseDouble(txNumber2.getText());
			txResult.setText(String.valueOf(num1 - num2));
		}
		if (jrbMul.isSelected() == true) {
			num1 = Double.parseDouble(txNumber1.getText());
			num2 = Double.parseDouble(txNumber2.getText());
			txResult.setText(String.valueOf(num1 * num2));
		}
		if (jrbDiv.isSelected() == true) {
			num1 = Double.parseDouble(txNumber1.getText());
			num2 = Double.parseDouble(txNumber2.getText());
			if (num2 == 0) {
				JOptionPane.showMessageDialog(txNumber2, "Math Error");
			}
			txResult.setText(String.valueOf(num1 / num2));
		}

	}
}
