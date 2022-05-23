
public abstract class AShape implements IShape {
	protected CartPt loc;

	protected AShape(CartPt loc) {
		super();
		this.loc = loc;
	}


	
	public abstract double area();

	
	public double distanceTo(CartPt point) {
		return loc.distanceTo(point);
	}

	
	public abstract boolean contains(CartPt point) ;


	public abstract Square boundingBox() ;

	
	public  double distanceToO() {
		return loc.distanceToO();
	}

}
