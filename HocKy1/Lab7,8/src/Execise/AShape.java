package Execise;

public abstract class AShape implements IShape {
	protected CartPt loc;

	public AShape(CartPt loc) {
		this.loc = loc;
	}

	public abstract double area();

	public double distanceToO() {
		return this.loc.distanceToO();
//		return Math.sqrt(this.loc.getX() * this.loc.getX() + this.loc.getY() * this.loc.getY());
	}

	public double distanceTo(CartPt Point) {
		return this.loc.distanceTo(Point);
	}
//		return Math.sqrt((this.loc.getX() - Point.getX()) * (this.loc.getX() - Point.getX())
//				+ (this.loc.getY() - Point.getY()) * (this.loc.getY() - Point.getY()));
//	}

	public abstract boolean contains(CartPt point);

	public abstract Square boundingBox();

}
