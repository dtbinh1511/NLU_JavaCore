package Execise;

public interface IShape {
	public abstract double area();

	public double distanceToO() ;
	public double distanceTo(CartPt Point) ;

	public boolean contains(CartPt point);

	public  Square boundingBox();

}
