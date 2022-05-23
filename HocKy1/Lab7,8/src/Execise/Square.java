package Execise;

public class Square extends AShape {
	private int size;

	protected Square(CartPt loc, int size) {
		super(loc);
		this.size = size;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.size * this.size;
	}

	public boolean between(int value, int low, int hight) {
		return (value >= low) && (value <= hight);
	}

	@Override
	public boolean contains(CartPt point) {
		// TODO Auto-generated method stub
		return (this.between(point.getX(), this.loc.getX(), this.loc.getX() + this.size)
				&& this.between(point.getY(), this.loc.getY(), this.loc.getY() + this.size));
	}

	@Override
	public Square boundingBox() {
		// TODO Auto-generated method stub
		return new Square(this.loc, this.size);
	}
}
