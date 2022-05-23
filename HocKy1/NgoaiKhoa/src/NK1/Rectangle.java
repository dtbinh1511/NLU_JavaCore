package NK1;

public class Rectangle {
	private CartPt location;
	private int width, height;

	public Rectangle(CartPt location, int width, int height) {

		this.location = location;
		this.width = width;
		this.height = height;
	}

//// Tính khoảng cách từ góc trái trên của hình chữ nhật đến tâm O
//	public double distanceToO() {
//		return this.location.distanToO();
//	}

// Tính khoảng cách từ tâm của hình chữ nhật đến tâm O
	public double distanceCenterToO() {
		return this.location.distanceCenterToO(this.width, this.height);
	}
}
