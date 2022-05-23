
public interface IShape {
	double area();

	double distanceTo(CartPt point);

	boolean contains(CartPt point);

	Square boundingBox();

	double distanceToO();

}
