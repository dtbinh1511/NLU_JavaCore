package Copy;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowBoxLayout extends JFrame implements ActionListener {
	// create a label to display flags
	private JLabel flag = new JLabel("");
	// create image icons for flags
	private ImageIcon iUS = new ImageIcon("ImageIcon/us.png");
	private ImageIcon iCanada = new ImageIcon("ImageIcon/canada.png");
	private ImageIcon iNorway = new ImageIcon("ImageIcon/norway.png");
	private ImageIcon iAustralia = new ImageIcon("ImageIcon/australia.png");
	private ImageIcon iGermany = new ImageIcon("ImageIcon/germany.png");

	// create buttons to select images
	private JButton jbUS, jbCanada, jbNorway, jbAustralia, jbGermany;

	public ShowBoxLayout() {

		JPanel panel1 = new JPanel();
		BoxLayout bl1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
		panel1.setLayout(bl1);

		JPanel panel2 = new JPanel();
		BoxLayout bl2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
		panel2.setLayout(bl2);
// add vao panel 1
		panel1.add(new JButton("Print", new ImageIcon("ImageIcon/print.png")));
		panel1.add(new JButton("Save", new ImageIcon("ImageIcon/save.png")));
		panel1.add(new JButton("New", new ImageIcon("ImageIcon/new.png")));
//add vao panel 2
		panel2.add(jbUS = new JButton("US       "));
		jbUS.addActionListener(this);
		panel2.add(jbCanada = new JButton("Canada   "));
		jbCanada.addActionListener(this);
		panel2.add(jbAustralia = new JButton("Australia"));
		jbAustralia.addActionListener(this);
		panel2.add(jbGermany = new JButton("Germany  "));
		jbGermany.addActionListener(this);
		panel2.add(jbNorway = new JButton("Norway   "));
		jbNorway.addActionListener(this);

		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.EAST);
		add(flag, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		ShowBoxLayout box = new ShowBoxLayout();
		box.setTitle("Box Layout");
		box.setSize(300, 200);
		box.setVisible(true);
		box.setLocationRelativeTo(null);
		box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (jbUS == e.getSource())
			flag.setIcon(iUS);
		if (jbAustralia == e.getSource())
			flag.setIcon(iAustralia);
		if (jbGermany == e.getSource())
			flag.setIcon(iGermany);
		if (jbNorway == e.getSource())
			flag.setIcon(iNorway);
		if (jbCanada == e.getSource())
			flag.setIcon(iCanada);

	}
}
