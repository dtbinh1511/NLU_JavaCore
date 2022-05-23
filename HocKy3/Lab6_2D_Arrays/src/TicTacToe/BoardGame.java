package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BoardGame extends JFrame implements ActionListener {
	private JButton jbtExit, jbtNew, jbtHelp;
	private JLabel xPlayer, oPlayer;
	private Panel panel;

	public BoardGame() {
		panel = new Panel();
		setLayout(new BorderLayout());
		add(panel, BorderLayout.EAST);
		add(setSupport(), BorderLayout.CENTER);
		setFrame();
		setTitle("Tic_Tac_Toe");
	}

	public static void main(String[] args) {
		new BoardGame();
	}

	public void setFrame() {
		setSize(440, 350);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public JPanel setSupport() {
		JPanel panel = new JPanel(new BorderLayout());
		add(panel);
		panel.add(setPlay(), BorderLayout.CENTER);
		panel.add(setResult(), BorderLayout.SOUTH);
		panel.setBackground(new Color(151, 255, 255));
		return panel;
	}

	public JPanel setPlay() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(jbtNew = new JButton("New Game"));
		panel.add(jbtHelp = new JButton("Help"));
		panel.add(jbtExit = new JButton("Exit"));
		panel.setBackground(new Color(151, 255, 255));
		jbtNew.addActionListener(this);
		jbtHelp.addActionListener(this);
		jbtExit.addActionListener(this);

		setFormatButton(jbtNew);
		setFormatButton(jbtHelp);
		setFormatButton(jbtExit);

		return panel;
	}

	public void setFormatButton(JButton button) {
		button.setBackground(new Color(151, 255, 255));
		button.setFont(new Font("Brush Script MT", Font.BOLD, 16));
		button.setPreferredSize(new Dimension(100, 50));
		button.setForeground(new Color(222, 49, 49));

	}

	public JPanel setResult() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(xPlayer = new JLabel("X_Win:" + this.panel.getScoreX()));
		panel.add(oPlayer = new JLabel("O_Win:" + this.panel.getScoreO()));
		panel.setBackground(new Color(151, 255, 255));
		oPlayer.setForeground(new Color(255, 0, 0));
		xPlayer.setForeground(new Color(255, 0, 0));

		oPlayer.setPreferredSize(new Dimension(50, 50));
		xPlayer.setPreferredSize(new Dimension(50, 50));

		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtExit) {
			System.exit(0);
		}
		if (e.getSource() == jbtNew) {
			remove(panel);
			add(panel = new Panel(), BorderLayout.EAST);
			revalidate();
		}
		if (e.getSource() == jbtHelp) {
			JOptionPane.showMessageDialog(null,
					"Tic-tac-toe là một trò chơi phổ biến dùng viết trên bàn cờ giấy có chín ô, 3x3." + "\n"
							+ " Hai người chơi, người dùng ký hiệu O, người kia dùng ký hiệu X,"
							+ " lần lượt điền ký hiệu của mình vào các ô." + "\n"
							+ " Người thắng là người thể tạo được đầu tiên một dãy ty ký hiệu của mình,"
							+ " ngang dọc hay chéo đều được." + "\n" + " *Note: " + " New game: tạo trò chơi mới."
							+ " Exit: Thoát trò chơi.");

		}
	}

}
