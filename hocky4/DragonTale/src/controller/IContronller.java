package controller;

import java.awt.Graphics2D;

public interface IContronller {
	public void update();

	public void draw(Graphics2D g2);

	public void up();

	public void down();

	public void left(boolean left);

	public void right(boolean right);

	public void w(boolean w);

	public void e(boolean e);

	public void r();

	public void f();

	public void select();
}
