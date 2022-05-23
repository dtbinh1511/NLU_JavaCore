package Execise;

public class CartPt {
	private int x, y;

	protected CartPt(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double distanceToO() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	public double distanceTo(CartPt point) {
		return Math.sqrt((point.x - this.x) * (point.x - this.x) + (point.y - this.y) * (point.y - this.y));
	}

	public CartPt translate(int dx, int dy) {
		return new CartPt(this.x + dx, this.y + dy);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

}
