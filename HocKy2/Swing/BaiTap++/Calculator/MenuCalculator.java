package Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuCalculator extends JMenuBar implements ActionListener {
	PanelCalculator PC;
	JMenu menuFile, menuHelp;
	JMenuItem itemExit;

	public MenuCalculator(PanelCalculator PC) {
		super();
		this.PC = PC;

		// add jmenu
		add(menuFile = new JMenu("File"));
		add(menuHelp = new JMenu("Help"));
		// add item vao menu
		menuHelp.add(itemExit = new JMenuItem("Exit"));
		itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		itemExit.addActionListener(this);
		//
		menuFile.setMnemonic('F');
		menuHelp.setMnemonic('H');
		itemExit.setMnemonic('E');
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itemExit) {
			System.exit(0);
		}
	}

}
