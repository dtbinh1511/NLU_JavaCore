
public class CartPt {
	protected int x, y;

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

	public void translate(int dx, int dy) {
		new CartPt(dx, dy);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

}
