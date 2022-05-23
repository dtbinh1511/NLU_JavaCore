package NK3;

public class CartPt {
	private int x, y;

	public CartPt(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public double distanceToO() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	public double distanceTo(CartPt other) {
		return Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y));
	}

}
