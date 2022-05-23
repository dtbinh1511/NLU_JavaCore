package observer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.entity.Player;

public class HUD1 extends JFrame implements Observer {
	private Player player;

	private BufferedImage image;
	private Font font;

	// Jframe
	private BufferedImage imageDraw;
	private final int WIDTH = 200;
	private final int HEIGHT = 100;
	private JPanel mainPanel;
	Graphics2D g;
	

	public HUD1(Player p) {
		player = p;
		p.addObserver(this);
		init();
		
		
		
	
	}
	public void init() {
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/HUD/hud.gif"));
			font = new Font("Arial", Font.PLAIN, 14);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/// init Frame

		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		this.add(mainPanel);
		
		this.setTitle("Hub1 observer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		
		g = (Graphics2D) mainPanel.getGraphics();
		
	}

	public void draw(Graphics2D g) {
		g.drawImage(image, 0, 10, null);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(player.getHealth() + "/" + player.getMaxHealth(), 30, 25);
		g.drawString(player.getFire() / 100 + "/" + player.getMaxFire() / 100, 30, 45);
		if(!this.isVisible())
			this.setVisible(true);
	

	}

	@Override
	public void update(Player player) {
		this.player = player;
		draw(g);
//		System.out.println("Hub1 has been update, HP player now is :" + player.getHealth() + " , Fire player now is : "
//				+ player.getFire());
	
	}
}
