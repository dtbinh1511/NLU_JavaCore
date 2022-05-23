package Bai12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ThamKhao extends JFrame {
	private JRadioButton jd1, jd2, jd3;

	public static void main(String[] args) {
		new ThamKhao();
	}

	public ThamKhao() {
		setLayout(new GridLayout(2, 3));
		// JPanel p = new JPanel();
		show red = new show(show.OVAL, Color.RED);
		add(red);
		show green = new show(show.OVAL, Color.GREEN);
		add(green);
		show yellow = new show(show.OVAL, Color.YELLOW);
		add(yellow);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		add(p1);
		add(new JLabel("Chọn loại đèn: "));
		JRadioButton jd1 = new JRadioButton("Đỏ");
		add(jd1);

		// Xu li red
		jd1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				yellow.setFillesd(false);
				yellow.repaint();

				green.setFillesd(false);
				green.repaint();

				red.setFillesd(!red.isFillesd());
				red.repaint();

			}
		});
		JRadioButton jd2 = new JRadioButton("Xanh");
		add(jd2);

		jd2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				yellow.setFillesd(false);
				yellow.repaint();

				green.setFillesd(!green.isFillesd());
				green.repaint();

				red.setFillesd(false);
				red.repaint();

			}
		});

		JRadioButton jd3 = new JRadioButton("Vàng");
		add(jd3);
		jd3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				yellow.setFillesd(!yellow.isFillesd());
				yellow.repaint();

				green.setFillesd(false);
				green.repaint();

				red.setFillesd(false);
				red.repaint();

			}
		});
		ButtonGroup g = new ButtonGroup();
		g.add(jd1);
		g.add(jd2);
		g.add(jd3);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	class show extends JPanel {
		public static final int OVAL = 4;
		private int type = 1;
		private boolean fillesd = false;
		private Color color;

		public show(int type) {
			this.type = type;
		}

		public show(int type, Color color) {
			this.type = type;
			this.color = color;
		}

		public boolean isFillesd() {
			return fillesd;
		}

		public void setFillesd(boolean fillesd) {
			this.fillesd = fillesd;
		}

		public Dimension getPreferrectSize() {
			return new Dimension(80, 80);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			switch (type) {
			case OVAL:
				g.setColor(this.color);
				if (fillesd)
					g.fillOval(10, 10, 70, 70);
				else
					g.setColor(color.black);
				g.fillOval(10, 10, 70, 70);
				g.drawOval(10, 10, 70, 70);
				break;
			default:
				break;

			}
		}
	}

}
