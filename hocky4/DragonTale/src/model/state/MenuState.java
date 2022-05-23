package model.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import controller.ControllerMenuState;
import model.tileMap.Background;

public class MenuState extends AState {

	private Background bg;

	private int currentChoice = 0;
	private String[] options = { "Start", "Help", "Quit" };

	private Color titleColor;
	private Font titleFont;

	private Font font;

	public MenuState(GameStateManager gsm) {

		this.gsm = gsm;

		try {

			bg = new Background("/Backgrounds/background-menu.png", 1);
			bg.setVector(-0.1, 0);

			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);

			font = new Font("Arial", Font.PLAIN, 12);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void init() {
	}

	public void update() {
		bg.update();
	}

	public void draw(Graphics2D g) {

		// draw bg
		bg.draw(g);

		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Dragon Tale", 80, 70);

		// draw menu options
		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 150, 150 + i * 15);
		}

	}

	@Override
	public void select() {
		if (currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		}
		if (currentChoice == 1) {
			// help
		}
		if (currentChoice == 2) {
			System.exit(0);
		}
	}

	public int getCurrentChoice() {
		return currentChoice;
	}

	public void setCurrentChoice(int currentChoice) {
		this.currentChoice = currentChoice;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

//	public void keyReleased(int k) {
//	}

	@Override
	public void up() {
		currentChoice--;
		if (currentChoice == -1) {
			currentChoice = options.length - 1;
		}
	}

	@Override
	public void down() {
		currentChoice++;
		if (currentChoice == options.length) {
			currentChoice = 0;
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

}
