
import javax.swing.JFrame;

public class Paint extends JFrame {
	public Paint() {
		PaintPanel pp = new PaintPanel();

		setJMenuBar(new MyMenuBar(pp));
		getContentPane().add(pp);
		setTitle("Paint");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(3);
	}

	public static void main(String[] args) {
		new Paint();

	}
}
