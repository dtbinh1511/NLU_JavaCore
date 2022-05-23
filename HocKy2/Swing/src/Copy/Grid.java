package Copy;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Grid extends JFrame {
	public Grid(String title) {
		super(title);
		setLayout(new GridLayout(3, 2, 5, 10));
		/* rows 3: số dòng
		 * cols 2: số cột
		 * hgap 5: khoảng cách bên trái
		 * vgap 10: khoảng cách bên trên
*/
		add(new JLabel("First name"));
		add(new JTextField(8));
		add(new JLabel("MI"));
		add(new JTextField(1));
		add(new JLabel("Last name"));
		add(new JTextField(8));
		setSize(300, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		Grid frame = new Grid("Show Grid Layout");
	}
}
