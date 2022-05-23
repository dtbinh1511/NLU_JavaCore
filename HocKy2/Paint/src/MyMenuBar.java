
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MyMenuBar extends JMenuBar {
	JMenu shapeMenu, colorMenu , eraser;
	JMenuItem jmiLine, jmiCircle, jmiRectangle, jmiPen, jmiFillOval, jmiFillRect, jmiExit;
	JRadioButtonMenuItem jrmiBlack, jrmiBlue, jrmiGreen, jrmiRed;

	PaintPanel pp;
	
	public MyMenuBar(PaintPanel pp) {
		this.pp = pp;
		
		shapeMenu = new JMenu("Shape");
		add(shapeMenu);
		MyAction action = new MyAction(pp);
		
		shapeMenu.add(jmiLine = new JMenuItem("Line"));
		jmiLine.setActionCommand("Line");
		jmiLine.addActionListener(action);
		
		shapeMenu.add(jmiCircle = new JMenuItem("Circle"));
		jmiCircle.setActionCommand("Circle");
		jmiCircle.addActionListener(action);
		
		shapeMenu.add(jmiRectangle = new JMenuItem("Rectangle"));
		jmiRectangle.setActionCommand("Rec");
		jmiRectangle.addActionListener(action);
		
		shapeMenu.add(jmiPen = new JMenuItem("Pen"));
		jmiPen.setActionCommand("Pen");
		jmiPen.addActionListener(action);
		
		shapeMenu.add(jmiFillOval = new JMenuItem("Fill Oval"));
		jmiFillOval.setActionCommand("FillOval");
		jmiFillOval.addActionListener(action);
		
		shapeMenu.add(jmiFillRect = new JMenuItem("Fill Rect"));
		jmiFillRect.setActionCommand("FillRect");
		jmiFillRect.addActionListener(action);
		
		shapeMenu.addSeparator();
		shapeMenu.add(jmiExit = new JMenuItem("Exit"));
		jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		jmiExit.addActionListener(action);
		
		colorMenu = new JMenu("Color");
		add(colorMenu);
		ButtonGroup bg = new ButtonGroup();
		colorMenu.add(jrmiBlack = new JRadioButtonMenuItem("Black"));
		jrmiBlack.setActionCommand("Black");
		jrmiBlack.addActionListener(action);
		bg.add(jrmiBlack);
		colorMenu.add(jrmiBlue = new JRadioButtonMenuItem("Blue"));
		jrmiBlue.setActionCommand("Blue");
		jrmiBlue.addActionListener(action);
		bg.add(jrmiBlue);
		colorMenu.add(jrmiGreen = new JRadioButtonMenuItem("Green"));
		jrmiGreen.setActionCommand("Green");
		jrmiGreen.addActionListener(action);
		bg.add(jrmiGreen);
		colorMenu.add(jrmiRed = new JRadioButtonMenuItem("Red"));
		jrmiRed.setActionCommand("Red");
		jrmiRed.addActionListener(action);
		bg.add(jrmiRed);
		

//		eraser = new JMenu("Eraser");
//		add(eraser);

		colorMenu.setMnemonic(KeyEvent.VK_C);
		shapeMenu.setMnemonic(KeyEvent.VK_S);
//		eraser.setMnemonic(KeyEvent.VK_E);
		
		
	}

}
