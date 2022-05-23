package NK3;

public class Circle extends AShape {
	private CartPt location;
	private int radius;

	public Circle(CartPt location, int radius) {

		this.location = location;
		this.radius = radius;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.radius * this.radius * Math.PI;
	}

	@Override
	public double distanceToO() {
		// TODO Auto-generated method stub
		return this.location.distanceToO();
	}

	@Override
// Inside of Circle
	public boolean contains(CartPt point) {
		// TODO Auto-generated method stub
		return false;
	}

}
