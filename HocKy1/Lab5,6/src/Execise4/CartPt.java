package Execise4;

public class CartPt {
	private int x;
	private int y;

	public CartPt(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
// khoang cach tu tam duong tron den O

	public double distanceToO() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}
}
