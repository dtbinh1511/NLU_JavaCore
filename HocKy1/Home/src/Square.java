
public class Square extends AShape {

	protected Square(CartPt loc) {
		super(loc);
		// TODO Auto-generated constructor stub
	}

	protected int size;

	@Override
	public double area() {

		return this.size * this.size;
	}

	@Override
	public Square boundingBox() {
		return null;
	}

	@Override
	public boolean contains(CartPt point) {
		// TODO Auto-generated method stub
		return false;
	}

}
