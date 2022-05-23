package Execise2;

public class CartPt {
	int x;
	int y;

	public CartPt(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

//khoang cach tu mot diem toi tam O
	public double distanceToO() {
		return (Math.sqrt(this.x * this.x + this.y * this.y));
	}
// di chuyen toa do de ra mot toa do moi
	public CartPt translate(int dx, int dy) {
		return new CartPt(this.x + dx, this.y + dy);
	}
}
