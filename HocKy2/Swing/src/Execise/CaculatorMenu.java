package Execise;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.html.StyleSheet.BoxPainter;

public class CaculatorMenu extends JFrame {
	private JLabel jlbNumber1, jlbNumber2, jlbResult;
	private JButton jbtAdd, jbtSub, jbtMul, jbtDiv;
	private ImageIcon iAdd, iSub, iMul, iDiv;
	private JTextField txNumber1, txNumber2, txResult;
	private JMenuItem jmiAdd, jmiSub, jmiMul, jmiDiv;

	public CaculatorMenu() {

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		iAdd = new ImageIcon("ImageIcon/add.png");
		iSub = new ImageIcon("ImageIcon/sub.png");
		iMul = new ImageIcon("ImageIcon/mul.png");
		iDiv = new ImageIcon("ImageIcon/div.png");

		jbtAdd = new JButton("Add", iAdd);
		jbtSub = new JButton("Subtract", iSub);
		jbtMul = new JButton("Multiply", iMul);
		jbtDiv = new JButton("Divide", iDiv);

		jlbNumber1 = new JLabel("Number1");
		txNumber1 = new JTextField(3);
		jlbNumber2 = new JLabel("Number2");
		txNumber2 = new JTextField(3);
		jlbResult = new JLabel("Result");
		txResult = new JTextField(5);

		// jPanel1
		JPanel panel = new JPanel();
		panel.add(jlbNumber1);
		panel.add(txNumber1);
		panel.add(jlbNumber2);
		panel.add(txNumber2);
		panel.add(jlbResult);
		panel.add(txResult);

		// jPanel2
		JPanel panel1 = new JPanel();
		panel1.add(jbtAdd);
		panel1.add(jbtSub);
		panel1.add(jbtMul);
		panel1.add(jbtDiv);
		add(panel);
		add(panel1);
// Create A Menu
		// Create JMenuBar : thanh menu bar
		JMenuBar jmb = new JMenuBar();
		// create menu
		JMenu operationMenu = new JMenu("Operation");
		JMenu exitMenu = new JMenu("Exit");

		jmb.add(operationMenu);
		jmb.add(exitMenu);

		// jMenuItem
		operationMenu.add(jmiAdd = new JMenuItem("Add", iAdd));
		operationMenu.addSeparator();
		operationMenu.add(jmiSub = new JMenuItem("Subtract", iSub));
		operationMenu.addSeparator();
		operationMenu.add(jmiMul = new JMenuItem("Multiply", iMul));
		operationMenu.addSeparator();
		operationMenu.add(jmiDiv = new JMenuItem("Divide", iDiv));
		//create mnenonics
		operationMenu.setMnemonic('O');
		exitMenu.setMnemonic('E');
		jmiAdd.setMnemonic('A');
		jmiSub.setMnemonic('S');
		jmiMul.setMnemonic('M');
		jmiDiv.setMnemonic('D');

		// create accelerator
		jmiAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		jmiSub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		jmiMul.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		jmiDiv.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		// set menu
		setJMenuBar(jmb);

		// for jFrame;
		pack();
		setTitle("Caculator Using Menu");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CaculatorMenu();
	}

}
