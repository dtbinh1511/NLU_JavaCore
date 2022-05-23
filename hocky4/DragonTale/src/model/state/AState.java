package model.state;

import java.awt.Graphics2D;

public abstract class AState {

	protected GameStateManager gsm;

	public abstract void init();

	public abstract void update();

	public abstract void draw(Graphics2D g);

	public abstract void up();

	public abstract void down();

	public abstract void left(boolean left);

	public abstract void right(boolean right);

	public abstract void w(boolean w);

	public abstract void e(boolean e);

	public abstract void r();

	public abstract void f();

	public abstract void select();

}
