package Caro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelCaro extends JPanel implements ActionListener {
	Color x_cl = Color.RED;
	Color y_cl = Color.BLUE;
	int count = 0, column = 20, row = 20, size = 0;
	private JButton[][] button = new JButton[column][row];
	int tick[][] = new int[column][row];

	public PanelCaro() {
		setLayout(new GridLayout(column, row));
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				button[i][j] = new JButton(" ");
				button[i][j].setBackground(Color.WHITE);
				button[i][j].addActionListener(this);
				tick[i][j] = 0;
				button[i][j].setPreferredSize(new Dimension(20, 20));
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				add(button[i][j]);
			}
		}
	}

	public boolean checkWin(int i, int j) {
		int count, row, column;
		
		/*
		 * ktra hang x x x x x
		 */
		count = 0;
		row = i;
		while (button[i][j].getText() == button[row][j].getText()) {
			count++;
			row++;
		}
		row = i - 1;
		while (button[i][j].getText() == button[row][j].getText()) {
			row--;
			count++;
		}
		if (count > 4)
			return true;
		/*
		 * kiem tra cot '
		 * x 
		 * x 
		 * x 
		 * x 
		 * x
		 */
		count = 0;
		column = j;
		while (button[i][j].getText() == button[i][column].getText()) {
			count++;
			column++;
		}
		column = j - 1;
		while (button[i][j].getText() == button[i][column].getText()) {
			count++;
			column--;
		}
		if (count > 4)
			return true;
		/*
		 * ktra duong cheo 
		 * x 
		 *  x 
		 *   x 
		 *    x 
		 *     x
		 */
		count = 0;
		row = i;
		column = j;
		while (button[i][j].getText() == button[row][column].getText()) {
			count++;
			row++;
			column++;
		}
		row = i - 1;
		column = j - 1;
		while (button[i][j].getText() == button[row][column].getText()) {
			count++;
			row--;
			column--;
		}
		if (count > 4)
			return true;
		/*
		 *      x 
		 *     x 
		 *    x 
		 *   x 
		 *  x
		 */
		count = 0;
		column = j;
		row = i;
		while (button[i][j].getText() == button[row][column].getText()) {
			count++;
			row++;
			column--;
		}
		row = i - 1;
		column = j + 1;
		while (button[i][j].getText() == button[row][column].getText()) {
			count++;
			row--;
			column++;
		}
		if (count > 4)
			return true;
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (e.getSource() == button[i][j]) {
					if (count % 2 == 0) {
						button[i][j].setText("X");
						count++;
						tick[i][j] = 1;
						button[i][j].setEnabled(false);
						button[i][j].setForeground(x_cl);
					} else if (count % 2 != 0) {
						button[i][j].setText("O");
						count++;
						tick[i][j] = -1;
						button[i][j].setEnabled(false);
						button[i][j].setForeground(y_cl);
					}
					if (checkWin(i, j) == true) {
						JOptionPane.showMessageDialog(null, button[i][j].getText() + " WIN");
					}
				}
			}
		}
	}
}
