package Bai7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListDemo extends JFrame implements ListSelectionListener {
	String[] arrColor = { "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Organe",
			"Pink", "Red", "White", "Yellow" };

	JList<String> colors = new JList<String>(arrColor);

	Color[] color = { Color.black, Color.blue, Color.cyan, Color.DARK_GRAY, Color.gray, Color.green, Color.lightGray,
			Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow };

	public ListDemo() {
		getContentPane().setLayout(new FlowLayout());
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.add(colors);

		// xử lý sự kiện
		colors.addListSelectionListener(this);
		
		setJFrame();
	}

	public static void main(String[] args) {
		new ListDemo();
	}

	public void setJFrame() {
		setSize(300, 300);
		setTitle("List Demo");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		getContentPane().setBackground(color[colors.getSelectedIndex()]);
	}
}
