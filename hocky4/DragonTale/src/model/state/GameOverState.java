package model.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import model.tileMap.Background;

public class GameOverState extends AState {
	private final String[] options = { "  Play again", "Return menu", "        Exit" };
	private int currentOption = 0;
	private Background bg;

	private final String title = "GAME OVER";
	private Font titleFont;
	private Color titleColor = Color.RED;
	private Font font;

	public GameOverState(GameStateManager gsm) {
		this.gsm = gsm;
		init();

	}

	@Override
	public void init() {
		try {
			bg = new Background("/Backgrounds/background-gameover.jpg", 0.1);

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);

			font = new Font("Arial", Font.PLAIN, 12);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void draw(Graphics2D g) {
		// draw bg
		bg.draw(g);

		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString(title, 80, 70);

		// draw menu options
		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == currentOption) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 130, 140 + i * 15);
		}
	}

	@Override
	public void select() {
		if (currentOption == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		}
		if (currentOption == 1) {
			gsm.setState(GameStateManager.MENUSTATE);
		}
		if (currentOption == 2) {
			System.exit(0);
		}
	}

	public int getCurrentOption() {
		return currentOption;
	}

	public void setCurrentOption(int currentOption) {
		this.currentOption = currentOption;
	}

	public String[] getOptions() {
		return options;
	}

	@Override
	public void up() {
		currentOption--;
		if (currentOption == -1) {
			currentOption = options.length - 1;
		}
	}

	@Override
	public void down() {
		currentOption++;
		if (currentOption == options.length) {
			currentOption = 0;
		}

	}

	@Override
	public void w(boolean w) {

	}

	@Override
	public void e(boolean e) {

	}

	@Override
	public void r() {

	}

	@Override
	public void f() {

	}

	@Override
	public void left(boolean left) {
		// TODO Auto-generated method stub

	}

	@Override
	public void right(boolean right) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
