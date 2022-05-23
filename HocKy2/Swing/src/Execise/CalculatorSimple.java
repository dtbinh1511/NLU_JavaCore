package Execise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.ietf.jgss.Oid;

public class CalculatorSimple extends JFrame implements ActionListener {
	private JLabel jlNumber1, jlNumber2, jlResult;
	private JButton jbtAdd, jbtSub, jbtMul, jbtDiv, jbtEqual;
	private JTextField txNumber1, txNumber2, txResult;

	public CalculatorSimple() {
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
		new CalculatorSimple();
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
		panel.add(jbtAdd = new JButton("+"));
		panel.add(jbtSub = new JButton("-"));
		panel.add(jbtMul = new JButton("*"));
		panel.add(jbtDiv = new JButton("/"));
		// event
		jbtAdd.addActionListener(this);
		jbtSub.addActionListener(this);
		jbtMul.addActionListener(this);
		jbtDiv.addActionListener(this);

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

		if (e.getSource() == jbtAdd) {
			try {
				num1 = Double.parseDouble(txNumber1.getText());
				num2 = Double.parseDouble(txNumber2.getText());
				txNumber1.setText("");
				txNumber2.setText("");
				txResult.setText(String.valueOf(num1 + num2));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Chưa nhập số");
			}
		}
		if (e.getSource() == jbtSub) {
			try {
				num1 = Double.parseDouble(txNumber1.getText());
				num2 = Double.parseDouble(txNumber2.getText());
				txNumber1.setText("");
				txNumber2.setText("");
				txResult.setText(String.valueOf(num1 - num2));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Chưa nhập số");
			}
		}
		if (e.getSource() == jbtMul) {
			try {
				num1 = Double.parseDouble(txNumber1.getText());
				num2 = Double.parseDouble(txNumber2.getText());
				txNumber1.setText("");
				txNumber2.setText("");
				txResult.setText(String.valueOf(num1 * num2));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Chưa nhập số");
			}
		}
		if (e.getSource() == jbtDiv) {
			try {
				num1 = Double.parseDouble(txNumber1.getText());
				num2 = Double.parseDouble(txNumber2.getText());
				if (num2 == 0) {
					JOptionPane.showMessageDialog(txNumber2, "Math Error");
				}
				txNumber1.setText("");
				txNumber2.setText("");
				txResult.setText(String.valueOf(num1 / num2));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Chưa nhập số");
			}
		}

	}
}
