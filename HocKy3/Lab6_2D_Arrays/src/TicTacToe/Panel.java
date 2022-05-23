package TicTacToe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {
	private JButton[][] jbt = new JButton[3][3];
	private boolean[][] check = new boolean[3][3];
	private int turn = 1;
	private int[][] mark = new int[3][3];

	private int scoreX = 0;
	private int scoreO = 0;

	public Panel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		add(panel);
		for (int i = 0; i < jbt.length; i++) {
			for (int j = 0; j < jbt[i].length; j++) {
				jbt[i][j] = new JButton("");
				jbt[i][j].setPreferredSize(new Dimension(100, 100));
				jbt[i][j].setBackground(new Color(240, 228, 228));
				jbt[i][j].addActionListener(this);
			}
		}
		for (int i = 0; i < jbt.length; i++) {
			for (int j = 0; j < jbt[i].length; j++) {
				panel.add(jbt[i][j]);
			}
		}
	}

	public int checkWin(int[][] check) {
		int count = 1;
		// check rows
		for (int i = 0; i < check.length; i++) {
			for (int j = 1; j < check[i].length; j++) {
				if (check[i][j] == check[i][0] && check[i][0] != 0)
					count++;
			}
			if (count == 3)
				return 1;
			else
				count = 1;
		}
		// check columns
		count = 1;
		for (int j = 0; j < check[0].length; j++) {
			for (int i = 1; i < check.length; i++) {
				if (check[i][j] == check[0][j] && check[0][j] != 0)
					count++;
			}
			if (count == 3)
				return 1;
			else
				count = 1;
		}
		// Check top-left to bottom-right
		count = 1;
		for (int i = 1; i < check.length; i++) {
			int k = i;
			if (check[i][k] == check[0][0] && check[0][0] != 0)
				count++;
			if (count == 3)
				return 1;
		}
		count = 1;
		// Check bottom-left to top-right
		int k = check.length - 2;
		for (int i = 1; i < check.length; i++) {
			if (check[i][k--] == check[0][check[0].length - 1] && check[0][check[0].length - 1] != 0) {
				count++;
			}
			if (count == 3)
				return 1;
		}
		return -1;
	}

	// check hòa
	public boolean checkDraws() {
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check[i].length; j++) {
				if (check[i][j] == false)
					return false;
			}
		}
		return true;
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < jbt.length; i++) {
			for (int j = 0; j < jbt[i].length; j++) {
				if (check[i][j] == false) {
					if (e.getSource() == jbt[i][j]) {
						turn++;
						if (turn % 2 == 0) {
							jbt[i][j].setIcon(new ImageIcon("image/xplayer.png"));
							check[i][j] = true;//
							mark[i][j] = 1;//
							if (checkWin(mark) == 1) {
								JOptionPane.showMessageDialog(null, "X win, New game to continue");
								scoreX++;
							} else if (checkDraws()) {
								JOptionPane.showMessageDialog(null, "Hòa");
							}

						} else {
							jbt[i][j].setIcon(new ImageIcon("image/oplayer.png"));
							check[i][j] = true;
							mark[i][j] = -1;
							if (checkWin(mark) == 1) {
								JOptionPane.showMessageDialog(null, "O win, New game to continue");
								scoreO++;
							}
						}
					}
				}

			}
		}
	}

	public int getScoreX() {
		return scoreX;
	}

	public int getScoreO() {
		return scoreO;
	}
}
