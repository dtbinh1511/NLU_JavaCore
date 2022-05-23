import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class De1 extends JFrame implements ActionListener {
	private JButton jbtBionary, jbtPrime, jbtExit;
	private JLabel lbInput, lbOutput, lbTitle;
	private JTextField txInput, txOutput;
	Dimension dim = new Dimension(80, 20);

	public De1() {
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
		new De1();
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
		panel.add(jbtBionary = new JButton("Bionary"));
		panel.add(jbtPrime = new JButton("Prime"));
		panel.add(jbtExit = new JButton("Exit"));
		// event
		jbtBionary.addActionListener(this);
		jbtPrime.addActionListener(this);
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

// kiem tra co phai la so nguyen to khong
	public boolean checkPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

// chuyen tu thap phan sang nhi phan
	public String tranlateBionary(int number) {
		String s = "";
		int binary[] = new int[40];
		int index = 0;
		while (number > 0) {
			binary[index++] = number % 2;
			number = number / 2;
		}
		for (int i = index - 1; i >= 0; i--) {
			s += binary[i];
		}
		return s;
	}

// event
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == jbtBionary) {
				int number = Integer.parseInt(txInput.getText());
				txOutput.setText(tranlateBionary(number));
			}
			if (e.getSource() == jbtPrime) {
				int number = Integer.parseInt(txInput.getText());
				if (checkPrime(number) == true) {
					txOutput.setText("Is Prime");
				} else {
					txOutput.setText("Is not prime");
				}
			}
		} catch (Exception e2) {
			txOutput.setText("Input value error");
		}
		if (e.getSource() == jbtExit) {
			System.exit(0);
		}
	}
}
