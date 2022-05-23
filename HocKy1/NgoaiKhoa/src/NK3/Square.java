package NK3;

public class Square extends AShape {
	private CartPt location;
	private int size;

	public Square(CartPt location, int size) {

		this.location = location;
		this.size = size;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.size * this.size;
	}

	@Override
	public double distanceToO() {
		// TODO Auto-generated method stub
		return this.location.distanceToO();
	}

	@Override
//Inside of Square
	public boolean contains(CartPt point) {
		// TODO Auto-generated method stub
		return false;
	}

}
