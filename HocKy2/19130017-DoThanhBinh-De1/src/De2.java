import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class De2 extends JFrame implements ActionListener {
	private JButton jbtOddNumber, jbtNumberOfDigits, jbtExit;
	private JLabel lbInput, lbOutput, lbTitle;
	private JTextField txInput, txOutput;
	Dimension dim = new Dimension(80, 20);

	public De2() {
		setLayout(new FlowLayout());
		add(createTitle());
		add(createRow1());
		add(createRow2());
		add(createButton());
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
		new De2();
	}

	public JPanel createTitle() {
		JPanel panel = new JPanel();
		panel.add(lbTitle = new JLabel("Mid- Term Exam"));
		return panel;
	}

	public JPanel createRow1() {
		JPanel panel = new JPanel();
		panel.add(lbInput = new JLabel("Input Value :"));
		panel.add(txInput = new JTextField(15));
		lbInput.setPreferredSize(dim);
		return panel;
	}

	public JPanel createRow2() {
		JPanel panel = new JPanel();
		panel.add(lbOutput = new JLabel("Output Value:"));
		panel.add(txOutput = new JTextField(15));
		lbOutput.setPreferredSize(dim);
		txOutput.setEnabled(false);
		return panel;
	}

	public JPanel createButton() {
		JPanel panel = new JPanel();
		panel.add(jbtNumberOfDigits = new JButton("NumberOfDigits"));
		panel.add(jbtOddNumber = new JButton("OddNumber"));
		panel.add(jbtExit = new JButton("Exit"));
		// event
		jbtOddNumber.addActionListener(this);
		jbtNumberOfDigits.addActionListener(this);
		jbtExit.addActionListener(this);
		return panel;
	}

	public void setJFrame() {
		setTitle("Ms Nga- Mr Toan");
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(300, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public int numberOfDigits(int number) {
		int check = 0;
		int sum = 0;
		while (number > 0) {
			check = number % 10;
			sum += check;
			number /= 10;
		}
		return sum;
	}

	public String oddNumber(int number) {
		String s = "";
		int check = 0;
		while (number > 0) {
			check = number % 10;
			if (check % 2 != 0) {
				s += check + " ";
			}
			number /= 10;
		}
		return s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == jbtNumberOfDigits) {
				int number = Integer.parseInt(txInput.getText());
				txOutput.setText(String.valueOf(numberOfDigits(number)));
			}
			if (e.getSource() == jbtOddNumber) {
				int number = Integer.parseInt(txInput.getText());
				txOutput.setText(String.valueOf(oddNumber(number)));
			}
		} catch (Exception e2) {
			txOutput.setText("Input error");
		}
		if (e.getSource() == jbtExit) {
			System.exit(0);
		}
	}

}
