
public class Circle extends AShape {

protected int radius;

protected Circle(CartPt loc, int radius) {
	super(loc);
	this.radius = radius;
}

@Override
public double area() {
	return 0;
}

@Override
public double distanceTo(CartPt point) {
	return 0;
}

@Override
public boolean contains(CartPt point) {
	return false;
}

@Override
public Square boundingBox() {
	return null;
}

@Override
public double distanceToO() {
	return 0;
}
	

	
}
