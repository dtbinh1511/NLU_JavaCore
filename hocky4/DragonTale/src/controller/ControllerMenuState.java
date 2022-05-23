package controller;

import java.awt.Graphics2D;

import model.state.MenuState;

public class ControllerMenuState implements IContronller {
	private MenuState state;

	public ControllerMenuState(MenuState state) {
		this.state = state;
	}

	public void up() {
		state.up();
	}

	public void down() {
		state.down();
	}

	@Override
	public void r() {
	}

	@Override
	public void f() {
	}

	@Override
	public void select() {
		state.select();
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
	public void w(boolean w) {
		// TODO Auto-generated method stub

	}

	@Override
	public void e(boolean e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		state.update();
	}

	@Override
	public void draw(Graphics2D g2) {
		state.draw(g2);
	}

}
