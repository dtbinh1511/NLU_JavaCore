package observer;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import model.entity.Player;

public class HUD implements Observer {

	private Player player;

	private BufferedImage image;
	private Font font;

	public HUD(Player p) {
		player = p;
		p.addObserver(this);
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/HUD/hud.gif"));
			font = new Font("Arial", Font.PLAIN, 14);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g) {

		g.drawImage(image, 0, 10, null);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(player.getHealth() + "/" + player.getMaxHealth(), 30, 25);
		g.drawString(player.getFire() / 100 + "/" + player.getMaxFire() / 100, 30, 45);

	}

	@Override
	public void update(Player player) {
		this.player = player;
//		System.out.println("Hub has been update, HP player now is :" + player.getHealth() + " , Fire player now is : "
//				+ player.getFire());

	}

}
