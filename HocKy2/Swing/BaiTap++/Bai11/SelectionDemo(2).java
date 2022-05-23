package Bai11;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectionDemo extends JFrame implements ListSelectionListener {
	String[] number = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve" };
	JList<String> lstNumber = new JList<String>(number);
	JCheckBox[] jcb = new JCheckBox[number.length];

	public SelectionDemo() {
		add(addList(), BorderLayout.WEST);
		add(createJCheckBox());
		setJFrame();

		lstNumber.addListSelectionListener(this);

	}

	public static void main(String[] args) {
		new SelectionDemo();
	}

	public JPanel addList() {
		JPanel panel = new JPanel();
		panel.add(lstNumber);
		return panel;
	}

	public JPanel createJCheckBox() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		for (int i = 0; i < jcb.length; i++) {
			jcb[i] = new JCheckBox("Selection " + i);
			jcb[i].setEnabled(false);
			panel.add(jcb[i]);
		}
		return panel;
	}

	public void setJFrame() {
		setTitle("Selection Demo");
		setSize(250, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		for (int i = 0; i < jcb.length; i++) {
			if (i == lstNumber.getSelectedIndex()) {
				jcb[lstNumber.getSelectedIndex()].setSelected(true);
			}
			else {
				jcb[i].setSelected(false);

			}
		}
	}

}
