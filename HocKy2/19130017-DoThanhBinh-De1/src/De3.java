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

public class De3 extends JFrame implements ActionListener {
	private JButton jbtMod3, jbtMod2, jbtExit;
	private JLabel lbInput, lbOutput, lbTitle;
	private JTextField txInput, txOutput;
	Dimension dim = new Dimension(80, 20);

	public De3() {
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
		new De3();
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
		panel.add(jbtMod3 = new JButton("Mod 3"));
		panel.add(jbtMod2 = new JButton("Mod 2"));
		panel.add(jbtExit = new JButton("Exit"));
		// event
		jbtMod3.addActionListener(this);
		jbtMod2.addActionListener(this);
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

	public String listMod2(int number) {
		String s = "";
		int check = 0;
		while (number > 0) {
			check = number % 10;
			if (check % 2 == 0) {
				s += check + " ";
			}
			number /= 10;
		}
		return s;
	}

	public String listMod3(int number) {
		String s = "";
		int check = 0;
		while (number > 0) {
			check = number % 10;
			if (check % 3 == 0) {
				s += check + " ";
			}
			number /= 10;
		}
		return s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == jbtMod2) {
				int number = Integer.parseInt(txInput.getText());
				txOutput.setText(listMod2(number));
			}
			if (e.getSource() == jbtMod3) {
				int number = Integer.parseInt(txInput.getText());
				txOutput.setText(listMod3(number));
			}

		} catch (Exception e1) {
			txOutput.setText("Input error");
		}
		if (e.getSource() == jbtExit) {
			System.exit(0);
		}
	}
}
