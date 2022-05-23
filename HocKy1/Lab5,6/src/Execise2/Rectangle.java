package Execise2;

public class Rectangle {
	private CartPt location;
	private int width;
	private int height;

	public Rectangle(CartPt location, int width, int height) {
		super();
		this.location = location;
		this.width = width;
		this.height = height;
	}

//khoang cach cua hinh chu nhat den tam O. diem trai tren toi tam O
	public double distanceToO() {
//		int x = this.location.x;
//		int y = this.location.y;
//		return Math.sqrt(x * x + y * y);
		return this.location.distanceToO();
	}
// tinh khoang cah tu tam hinh chu nhat den O
	public double distanceFromCenterToO() {
		return this.center().distanceToO();
	}
	public CartPt center() {
		return this.location.translate(height / 2, width / 2);
	}

}
