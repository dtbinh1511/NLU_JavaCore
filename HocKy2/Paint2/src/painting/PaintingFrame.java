package painting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PaintingFrame extends JFrame implements ActionListener {

	private PaintingPanel paintingPanel;

	private JPanel panelColor, panelTool;

	private JButton[] buttons = new JButton[6];
	private Color[] colors = { Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW };

	private JButton moreColor, pencil, line, rect, oval, clear, eraser;

	public PaintingFrame() {

		add(panelTool = new JPanel(), BorderLayout.NORTH);
		panelTool.add(pencil = setUpButtonTool("pencil"));
		panelTool.add(line = setUpButtonTool("line"));
		panelTool.add(rect = setUpButtonTool("rect"));
		panelTool.add(oval = setUpButtonTool("oval"));
		panelTool.add(eraser = setUpButtonTool("eraser"));
		panelTool.add(clear = new JButton("Clear"));
		clear.addActionListener(this);
		clear.setCursor(new Cursor(Cursor.HAND_CURSOR));

		add(panelColor = new JPanel(), BorderLayout.SOUTH);
		for (int i = 0; i < buttons.length; i++) {
			panelColor.add(buttons[i] = setUpButtonColor(colors[i]));
		}
		panelColor.add(moreColor = new JButton("More"));
		moreColor.addActionListener(this);
		moreColor.setCursor(new Cursor(Cursor.HAND_CURSOR));

		add(paintingPanel = new PaintingPanel(this));
		setSize(700, 500);
		setTitle("Painting");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JButton setUpButtonColor(Color color) {
		JButton button = new JButton();
		button.setBackground(color);
		button.setPreferredSize(new Dimension(30, 30));
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.addActionListener(this);
		return button;
	}

	public JButton setUpButtonTool(String name) {
		JButton button = new JButton(name + "");
//		button.setIcon(icon);
		button.setPreferredSize(new Dimension(80, 30));
		button.addActionListener(this);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		return button;
	}

	public static void main(String[] args) {
		new PaintingFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == e.getSource())
				paintingPanel.setColor(colors[i]);
		}
		if (moreColor == e.getSource()) {
			JColorChooser chooser = new JColorChooser();
			Color color = chooser.showDialog(null, "Selected Color", null);
			paintingPanel.setColor(color);
		}

		if (pencil == e.getSource()) {
			paintingPanel.setType(Tool.PENCIL);
			setCursor(Cursor.getDefaultCursor());
		}

		if (line == e.getSource()) {
			paintingPanel.setType(Tool.LINE);
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}

		if (rect == e.getSource()) {
			paintingPanel.setType(Tool.RECTANGLE);
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}

		if (oval == e.getSource()) {
			paintingPanel.setType(Tool.OVAL);
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}

		if (eraser == e.getSource()) {
			paintingPanel.setType(Tool.ERASER);
			setCursor(new Cursor(0));
		}

		if (clear == e.getSource()) {
			remove(paintingPanel);
			add(paintingPanel = new PaintingPanel(this));
			revalidate();
		}
	}
}
