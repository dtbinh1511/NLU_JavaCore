package Copy;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridBagDemo extends JFrame {
	public GridBagDemo() {
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints gridCon = new GridBagConstraints();
		JPanel panel = new JPanel();

		gridBag.
		setFrame();
	}

	public static void main(String[] args) {
		new GridBagDemo();
	}

	public void setFrame() {
		setTitle("GridBagLayout Demo");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
