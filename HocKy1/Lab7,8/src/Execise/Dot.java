package Execise;

public class Dot extends AShape {

	protected Dot(CartPt loc) {
		super(loc);
		
	}

	@Override
	public double area() {
	
		return 0;
	}

	@Override
	public boolean contains(CartPt point) {
	
		return this.loc.distanceTo(point) == 0;
	}

// bao hinh
	@Override
	public Square boundingBox() {
	
		return new Square(this.loc, 0);
	}

}
