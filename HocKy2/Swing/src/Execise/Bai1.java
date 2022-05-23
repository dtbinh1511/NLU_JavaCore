package Execise;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Bai1 extends JFrame implements ActionListener {
	private JLabel jlTitle, jlCat, jlRabbit, jlBuffalo, jlDeer, jlIcon;
	private JRadioButton jrbCat, jrbRabbit, jrbBuffalo, jrbDeer;
	private ImageIcon iCat, iRabbit, iBuffalo, iDeer;

	public Bai1() {
		add(createTitle(), BorderLayout.NORTH);
		add(createButton(), BorderLayout.WEST);
//add(createFrameImage());
		add(jlIcon = new JLabel(iCat = new ImageIcon("ImageIcon/cat.png")), BorderLayout.CENTER);
		add(jlIcon = new JLabel(iBuffalo = new ImageIcon("ImageIcon/buffalo.jpg")), BorderLayout.CENTER);
		add(jlIcon = new JLabel(iDeer = new ImageIcon("ImageIcon/deer.jpg")), BorderLayout.CENTER);
		add(jlIcon = new JLabel(iRabbit = new ImageIcon("ImageIcon/rabbit.jpg")), BorderLayout.CENTER);

		// event
		jrbCat.addActionListener(this);
		jrbBuffalo.addActionListener(this);
		jrbDeer.addActionListener(this);
		jrbRabbit.addActionListener(this);
		setJFrame();
	}

	public static void main(String[] args) {
		new Bai1();
	}

	public JPanel createTitle() {
		JPanel panel = new JPanel();

		panel.add(jlTitle = new JLabel("Choice animal favorite"), BorderLayout.CENTER);
		return panel;

	}

	public JPanel createButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		panel.add(jlCat = new JLabel("Cat"));
		panel.add(jrbCat = new JRadioButton());
		panel.add(jlCat = new JLabel("Rabbit"));
		panel.add(jrbRabbit = new JRadioButton());
		panel.add(jlCat = new JLabel("Buffalo"));
		panel.add(jrbBuffalo = new JRadioButton());
		panel.add(jlCat = new JLabel("Deer"));
		panel.add(jrbDeer = new JRadioButton());
		
		jrbBuffalo.setMnemonic(KeyEvent.VK_B);
		jrbRabbit.setMnemonic(KeyEvent.VK_R);
		jrbCat.setMnemonic(KeyEvent.VK_C);
		jrbDeer.setMnemonic(KeyEvent.VK_D);

		ButtonGroup btg = new ButtonGroup();
		btg.add(jrbBuffalo);
		btg.add(jrbCat);
		btg.add(jrbRabbit);
		btg.add(jrbDeer);

		return panel;
	}


	public void setJFrame() {
		setSize(300, 250);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jrbCat) {
			jlIcon.setIcon(iCat);
		}
		if (e.getSource() == jrbBuffalo) {
			jlIcon.setIcon(iBuffalo);
		}
		if (e.getSource() == jrbDeer) {
			jlIcon.setIcon(iDeer);
		}
		if (e.getSource() == jrbRabbit) {
			jlIcon.setIcon(iRabbit);
		}
	}
}
