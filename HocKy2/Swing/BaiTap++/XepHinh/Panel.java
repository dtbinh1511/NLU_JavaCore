package XepHinh;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel {
	JButton button[][] = new JButton[4][4];
	int count = 1;

	public Panel() {
		setLayout(new GridLayout(4, 4));
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				add(button[i][j] = new JButton("" + (4*(i-1)+j)));
			}
		}
	}
}
