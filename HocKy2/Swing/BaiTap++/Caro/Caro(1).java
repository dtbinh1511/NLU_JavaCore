package Caro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Caro extends JFrame implements ActionListener {
	PanelCaro panel = new PanelCaro();
	JButton jbtExit, jbtNew, jbtRule;

	public Caro() {
		add(panel);
		setJframe();
		add(createTool(), "North");

	}

	public static void main(String[] args) {
		new Caro();
	}

	public void setJframe() {
		setSize(1000, 700);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public JPanel createTool() {
		JPanel panel = new JPanel();
		panel.add(jbtNew = new JButton("New game"));
		panel.add(jbtRule = new JButton("Rule"));
		panel.add(jbtExit = new JButton("Exit"));
		jbtExit.addActionListener(this);
		jbtNew.addActionListener(this);
		jbtRule.addActionListener(this);
		return panel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtExit) {
			System.exit(0);
		}
		if (e.getSource() == jbtNew) {
			new Caro();
			this.dispose();
		}
		if (e.getSource() == jbtRule) {
			JOptionPane.showMessageDialog(null,
					"-	Cách chơi: \n" + " Người chiến thắng là người tạo được đường thẳng theo chiều dọc"
							+ " hoặc ngang hoặc chéo với chính xác 5 con cờ của mình.",
					"Thoát", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
