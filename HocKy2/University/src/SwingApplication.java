import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingApplication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String labelPrefix = "Number of button clicks: ";
	private int numClicks = 0;

	public SwingApplication(String title) {
		super(title);
		// Setting up a button and label
		final JLabel label = new JLabel(labelPrefix + "0    ");
		JButton button = new JButton("I'm a Swing button!");
		button.setMnemonic(KeyEvent.VK_I);
		// Handling event
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numClicks++;
				label.setText(labelPrefix + numClicks);
			}
		});

		JPanel pane = new JPanel();
		// Adding borders around components
		pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		// Setting up the layout
		pane.setLayout(new GridLayout(0, 1));
		// Adding components to container
		pane.add(button);
		pane.add(label);
		// Setting up the top-level container
		getContentPane().add(pane);
		// Handling event
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Calculating a frame size
		pack();
		// Show a frame
		setVisible(true);
	};

	public static void main(String[] args) {
		new SwingApplication("Click");
	}
}
