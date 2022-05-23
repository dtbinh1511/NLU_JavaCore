package Copy;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

public class JMenuDemo extends JFrame {
	public JMenuDemo() {
		JFrame frame = new JFrame();
		JMenuBar jmb = new JMenuBar();
		// create jMenu for jMenuBar
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		// add in jMenuBar
		jmb.add(fileMenu);
		jmb.add(helpMenu);

		// create icon for jMenuItem
		JMenuItem jmiNew, jmiSave, jmiPrint, jmiOpen;
		fileMenu.add(jmiNew = new JMenuItem("New"));
		fileMenu.addSeparator();
		fileMenu.add(jmiOpen = new JMenuItem("Open"));
		fileMenu.addSeparator();
		fileMenu.add(jmiSave = new JMenuItem("Save"));
		fileMenu.addSeparator();
		fileMenu.add(jmiPrint = new JMenuItem("Print"));
		jmiNew.setIcon((new ImageIcon("ImageIcon/new.png")));
		jmiSave.setIcon((new ImageIcon("ImageIcon/save.png")));
		jmiPrint.setIcon((new ImageIcon("ImageIcon/print.png")));
		jmiOpen.setIcon((new ImageIcon("ImageIcon/open.png")));

		// add in fileMenu
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("Exit"));

		// create jMenu for helpMenu
		JMenu softWare = new JMenu("Soft ware");
		JMenu hardWare = new JMenu("Hard Ware");
		// add in helpMenu
		helpMenu.add(softWare);
		helpMenu.add(hardWare);
		helpMenu.add(new JMenuItem("ComputerConsulting"));
		// add in softWare
		softWare.add(new JMenuItem("Linux"));
		softWare.add(new JMenuItem("Window 10"));
		softWare.add(new JMenuItem("Window 8"));
		// add in hardWare
		hardWare.add(new JMenuItem("CPU"));
		hardWare.add(new JMenuItem("RAM"));
		hardWare.add(new JMenuItem("ROM"));
		// create jCheckBox
		helpMenu.add(new JCheckBox("Check it"));
		// create color
		JMenu colorMenu = new JMenu("Color");
		helpMenu.add(colorMenu);
		// create button
		JRadioButton jRadioBlue, jRadioYellow, jRadioRed;
		colorMenu.add(jRadioBlue = new JRadioButton("Blue"));
		colorMenu.add(jRadioYellow = new JRadioButton("Yellow"));
		colorMenu.add(jRadioRed = new JRadioButton("Red"));
		// create only choice one color
		ButtonGroup btg = new ButtonGroup();
		btg.add(jRadioBlue);
		btg.add(jRadioYellow);
		btg.add(jRadioRed);

		// create mnemonic
		helpMenu.setMnemonic('H');
		fileMenu.setMnemonic('F');

		// create accelerator
		jmiNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		jmiPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		// JPopupMenu
		JPopupMenu pm = new JPopupMenu();
		pm.add(new JMenuItem("New"));
		pm.add(new JMenuItem("Open"));
		// create JFrame
		frame.setJMenuBar(jmb);
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JMenuDemo();
	}

}
