package Calculator;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class FrameCalculator extends JFrame {
	PanelCalculator panel = new PanelCalculator();
	public FrameCalculator() {
		add(panel);
		setJframe();
		setJMenuBar(new MenuCalculator(panel));
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new FrameCalculator();
	}
	public void setJframe() {
		setTitle("Calculator");
		setSize(360, 400);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
