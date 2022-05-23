package NK1;

public class Circle {
	private CartPt center;
	private int randius;

	public Circle(CartPt center, int randius) {
		super();
		this.center = center;
		this.randius = randius;
	}

// Tính khoảng cách từ tâm hình tròn đến tâm O
	public double distanceToO() {
		return this.center.distanceToO();
	}

// Tính chu vi của hình tròn
	public double perimeter() {
		return Math.PI * 2 * this.randius;
	}

// Tính diện tích của hình tròn
	public double area() {
		double result=Math.PI * this.randius * this.randius;
		return result;
	}

// Tính diện tích của chiếc nhẫn
	public double ring(Circle other) {
		return Math.abs(this.area() - other.area());
	}
}
