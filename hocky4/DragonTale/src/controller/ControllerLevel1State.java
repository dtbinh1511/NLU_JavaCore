package controller;

import java.awt.Graphics2D;

import model.state.Level1State;

public class ControllerLevel1State implements IContronller {
	private Level1State state;

	public ControllerLevel1State(Level1State state) {
		this.state = state;
	}

	@Override
	public void up() {
	}

	@Override
	public void down() {

	}

	@Override
	public void left(boolean left) {
		state.left(left);

	}

	@Override
	public void right(boolean right) {
		state.right(right);
	}

	@Override
	public void w(boolean w) {
		state.w(w);
	}

	@Override
	public void e(boolean e) {
		state.e(e);
	}

	@Override
	public void r() {
		state.r();
	}

	@Override
	public void f() {
		state.f();
	}

	@Override
	public void select() {
		state.select();
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
