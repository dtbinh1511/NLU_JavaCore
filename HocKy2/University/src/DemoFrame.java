
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DemoFrame extends JFrame {
	Toolkit kit;
	JButton locationButton, cursorButton, iconButton;

	public DemoFrame() {
		kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setSize(screenWidth / 2, screenHeight / 2);
		setTitle("untitled Frame");
		setResizable(false);
		Container pane = getContentPane();
		pane.setLayout(new FlowLayout());

		locationButton = new JButton(" Center a Frame");
		locationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLocationRelativeTo(null);
				setTitle("a Centered Frame");
			}
		});

		cursorButton = new JButton(" Set Cursor");
		cursorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
				setTitle("a Cross-Hair cursor");
			}
		});
		iconButton = new JButton(" set Frame Icon");
		iconButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image img = kit.getImage("E://Cá nhân//Ảnh/duc.jpg");
				setIconImage(img);
				setTitle("a Bird icon");
			}
		});
		pane.add(locationButton);
		pane.add(cursorButton);
		pane.add(iconButton);
		setVisible(true);

	}
}
