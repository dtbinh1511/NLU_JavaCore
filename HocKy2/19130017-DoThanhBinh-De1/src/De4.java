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

public class De4 extends JFrame implements ActionListener {
	private JButton jbtEvenSum, jbtOddSum, jbtExit;
	private JLabel lbInput, lbOutput, lbTitle;
	private JTextField txInput, txOutput;
	Dimension dim = new Dimension(80, 20);

	public De4() {
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
		new De4();
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
		panel.add(jbtEvenSum = new JButton("EvenSum"));
		panel.add(jbtOddSum = new JButton("OddSum"));
		panel.add(jbtExit = new JButton("Exit"));
		// event
		jbtEvenSum.addActionListener(this);
		jbtOddSum.addActionListener(this);
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

	public int evenSum(int number) {
		int check = 0;
		int sum = 0;
		while (number > 0) {
			check = number % 10;
			if (check % 2 == 0) {
				sum += check;
			}
			number /= 10;
		}
		return sum;
	}

	public int oddSum(int number) {
		int check = 0;
		int sum = 0;
		while (number > 0) {
			check = number % 10;
			if (check % 2 != 0) {
				sum += check;
			}
			number /= 10;
		}
		return sum;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == jbtEvenSum) {
				int number = Integer.parseInt(txInput.getText());
				txOutput.setText(String.valueOf(evenSum(number)));
			}
			if (e.getSource() == jbtOddSum) {
				int number = Integer.parseInt(txInput.getText());
				txOutput.setText(String.valueOf(oddSum(number)));
			}
		} catch (Exception e2) {
			txOutput.setText("Input error");
		}
		if (e.getSource() == jbtExit) {
			System.exit(0);
		}
	}

}
