package decorator;

public abstract class CondimentDecorator extends Beverage {

	public abstract String getDescription();

	@Override
	public abstract double cost();

}
