package Bai12;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TrafficLight extends JFrame implements ActionListener {
	PaintTraffic red = new PaintTraffic(PaintTraffic.OVAL, Color.RED);
	PaintTraffic green = new PaintTraffic(PaintTraffic.OVAL, Color.GREEN);
	PaintTraffic yellow = new PaintTraffic(PaintTraffic.OVAL, Color.YELLOW);
	JLabel jlRed, jlGreen, jlYellow;
	JRadioButton jrbRed, jrbGreen, jrbYellow;

	public JPanel createRadioButton() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Chọn loại đèn:"));
		panel.add(jrbRed = new JRadioButton("Đỏ"));
		panel.add(jrbGreen = new JRadioButton("Xanh"));
		panel.add(jrbYellow = new JRadioButton("Vàng"));

		ButtonGroup btg = new ButtonGroup();
		btg.add(jrbRed);
		btg.add(jrbGreen);
		btg.add(jrbYellow);
		
		// event
		jrbRed.addActionListener(this);
		jrbGreen.addActionListener(this);
		jrbYellow.addActionListener(this);

		return panel;
	}

	public void setJFrame() {
		setTitle("Traffic Light");
		setSize(400, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel createTraffic() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		panel.add(red);
		panel.add(green);
		panel.add(yellow);
		return panel;
	}

	public TrafficLight() {
		this.setLayout(new GridLayout(2, 1));
		add(createTraffic());
		add(createRadioButton());
		setJFrame();
	}

	public static void main(String[] args) {
		new TrafficLight();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== jrbRed) {
			yellow.setFilled(false);
			yellow.repaint();
			
			green.setFilled(false);
			green.repaint();
			
			red.setFilled(true);
			red.repaint();
		}
		if(e.getSource()== jrbGreen) {
			yellow.setFilled(false);
			yellow.repaint();
			
			green.setFilled(true);
			green.repaint();
			
			red.setFilled(false);
			red.repaint();
		}
		if(e.getSource()== jrbYellow) {
			yellow.setFilled(true);
			yellow.repaint();
			
			green.setFilled(false);
			green.repaint();
			
			red.setFilled(false);
			red.repaint();
		}
	}
}
