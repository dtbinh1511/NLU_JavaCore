package decorator;

public class Mocha extends CondimentDecorator{
	Beverage beverage;

	public Mocha(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " Mocha";
	}

	@Override
	public double cost() {		
		return beverage.cost() + 0.1;
	}
}
