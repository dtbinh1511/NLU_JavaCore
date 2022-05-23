package Execise;

public class Circle extends AShape {
	private int radius;

	protected Circle(CartPt loc, int radius) {
		super(loc);
		this.radius = radius;
	}

	@Override
	public double area() {
		return this.radius * this.radius * Math.PI;
	}

	@Override
	public boolean contains(CartPt point) {
		
		return this.loc.distanceTo(point) <= this.radius;
	}

	@Override
	public Square boundingBox() {
	
//	return new Square(new CartPt(this.loc.getX()- this.radius, this.loc.getY()- this.radius),this.radius* 2);
		return new Square(this.loc.translate(-this.radius, -this.radius), this.radius * 2);
	}
}
