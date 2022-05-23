package Execise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class CalculatorSimple3 extends JFrame implements ItemListener {
	private JLabel jlNumber1, jlNumber2, jlResult;
	private JCheckBox checkBoxAdd, checkBoxSub, checkBoxMul, checkBoxDiv;
	private JTextField txNumber1, txNumber2, txResult;

	public CalculatorSimple3() {
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
		new CalculatorSimple3();
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
		panel.add(checkBoxAdd = new JCheckBox("+"));
		panel.add(checkBoxSub = new JCheckBox("-"));
		panel.add(checkBoxMul = new JCheckBox("*"));
		panel.add(checkBoxDiv = new JCheckBox("/"));
		// event
		checkBoxAdd.addItemListener(this);
		checkBoxSub.addItemListener(this);
		checkBoxMul.addItemListener(this);
		checkBoxDiv.addItemListener(this);

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
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getItemSelectable() == checkBoxAdd) {
			num1 = Double.parseDouble(txNumber1.getText());
			num2 = Double.parseDouble(txNumber2.getText());
			txResult.setText(String.valueOf(num1 + num2));
		}
		if (e.getItemSelectable() == checkBoxSub) {
			num1 = Double.parseDouble(txNumber1.getText());
			num2 = Double.parseDouble(txNumber2.getText());
			txResult.setText(String.valueOf(num1 - num2));
		}
		if (e.getItemSelectable() == checkBoxMul) {
			num1 = Double.parseDouble(txNumber1.getText());
			num2 = Double.parseDouble(txNumber2.getText());
			txResult.setText(String.valueOf(num1 * num2));
		}
		if (e.getItem() == checkBoxDiv) {
			num1 = Double.parseDouble(txNumber1.getText());
			num2 = Double.parseDouble(txNumber2.getText());
			if (num2 == 0) {
				JOptionPane.showMessageDialog(txNumber2, "Math Error");
			}
			txResult.setText(String.valueOf(num1 / num2));
		}
	}
}
