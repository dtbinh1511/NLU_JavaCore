package Execise4;

public class Circle {
	private CartPt center;
	private int radius;

	public Circle(CartPt center, int radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

//khoang cach tu tam hinh tron den O
	public double distanceToO() {
		return this.center.distanceToO();

	}

// tinh chu vi hinh tron
	public double perimeter() {
		return 2 * Math.PI * this.radius;
	}

//tinh dien tich hinh tron
	public double area() {
		return Math.PI * this.radius * this.radius;
	}

//tinh dien tich cua chiec nhan
	public double ring(Circle orther) {

		return Math.abs(this.area() - orther.area());
	}
}
