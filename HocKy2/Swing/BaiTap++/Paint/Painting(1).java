package Paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Painting extends JFrame implements ActionListener {
	private PanelPaint paintingPanel;

	private JPanel panelColor, panelTool;

	private JButton[] buttons = new JButton[6];
	private Color[] colors = { Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW };

	private JButton moreColor, pencil, line, rect, oval, clear, eraser;

	public Painting() {
//		add(paintingPanel = new PanelPaint(this));
		add(createButton(), BorderLayout.NORTH);
//		add(createColor(), BorderLayout.SOUTH);

		setTitle("Paint");
		setVisible(true);
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Painting();
	}

	public JPanel createButton() {
		panelTool = new JPanel();
		panelTool.add(pencil = setUpButtonTool(new ImageIcon("ImageIcon/pencil.png")));
		panelTool.add(line = setUpButtonTool(new ImageIcon("ImageIcon/line.png")));
		panelTool.add(rect = setUpButtonTool(new ImageIcon("ImageIcon/rect.png")));
		panelTool.add(oval = setUpButtonTool(new ImageIcon("ImageIcon/oval.png")));
		panelTool.add(eraser = setUpButtonTool(new ImageIcon("ImageIcon/eraser.png")));
		panelTool.add(clear = new JButton("Clear"));
		
		clear.setPreferredSize(new Dimension(80, 30));
		clear.addActionListener(this);
		//
		pencil.setToolTipText("Pencil");
		line.setToolTipText("Line");
		rect.setToolTipText("Rectangle");
		oval.setToolTipText("Oval");
		eraser.setToolTipText("Eraser");
		panelTool.setToolTipText("a");
		return panelTool;
	}

	public JPanel createColor() {
		panelColor = new JPanel();
		for (int i = 0; i < buttons.length; i++) {
			panelColor.add(buttons[i] = setUpButtonColor(colors[i]));
		}
		panelColor.add(moreColor = new JButton("More Color"));
		moreColor.addActionListener(this);
		return panelColor;
	}

	public JButton setUpButtonColor(Color color) {
		JButton button = new JButton();
		button.setBackground(color);
		button.setPreferredSize(new Dimension(30, 30));
		button.addActionListener(this);
		return button;
	}

	public JButton setUpButtonTool(ImageIcon icon) {
		JButton button = new JButton(icon);
		button.setIcon(icon);
		button.setPreferredSize(new Dimension(80, 30));
		button.addActionListener(this);
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == e.getSource()) {
				paintingPanel.setColor(colors[i]);
			}
		}
		if (e.getSource() == moreColor) {
			JColorChooser chooser = new JColorChooser();
			Color color = chooser.showDialog(null, "Select Color", null);
			paintingPanel.setColor(color);
		}
		if (pencil == e.getSource()) {
			paintingPanel.setType(Tool.PENCIL);
		}

		if (line == e.getSource()) {
			paintingPanel.setType(Tool.LINE);
		}

		if (rect == e.getSource()) {
			paintingPanel.setType(Tool.RECTANGLE);
		}

		if (oval == e.getSource()) {
			paintingPanel.setType(Tool.OVAL);
		}

		if (eraser == e.getSource()) {
			paintingPanel.setType(Tool.ERASER);
		}

		if (clear == e.getSource()) {
			remove(paintingPanel);
			add(paintingPanel = new PanelPaint(this));
			revalidate();
		}
	}
}
