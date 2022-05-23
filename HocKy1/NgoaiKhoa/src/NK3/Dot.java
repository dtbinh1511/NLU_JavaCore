package NK3;

public class Dot extends AShape {
	private CartPt location;

	public Dot(CartPt location) {

		this.location = location;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double distanceToO() {
		// TODO Auto-generated method stub
		return this.location.distanceToO();
	}

	@Override
// inside of Dot
	public boolean contains(CartPt point) {
		// TODO Auto-generated method stub
		return this.location.distanceTo(point) == 0;
	}

}
