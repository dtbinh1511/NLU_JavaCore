package model.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import controller.ControllerGameOver;
import controller.ControllerGameVictory;
import model.entity.Player;
import model.tileMap.Background;

public class VictoryState extends AState {
	private final String[] options = { "  Play again", "Return menu", "        Exit" };
	private int currentOption = 0;
	private Background bg;

	private final String title = "YOU WON";
	private Font titleFont;
	private Color titleColor = Color.RED;
	private Font font;

	public VictoryState(GameStateManager gsm) {
		this.gsm = gsm;

		init();

	}

	@Override
	public void init() {
		try {
			bg = new Background("/Backgrounds/background-gameVictory.jpg", 0.1);

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);

			font = new Font("Arial", Font.PLAIN, 12);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {

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
	public void r() {

	}

	@Override
	public void f() {

	}

	@Override
	public void w(boolean w) {
		// TODO Auto-generated method stub

	}

	@Override
	public void e(boolean e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void left(boolean left) {
		// TODO Auto-generated method stub

	}

	@Override
	public void right(boolean right) {
		// TODO Auto-generated method stub

	}

}
