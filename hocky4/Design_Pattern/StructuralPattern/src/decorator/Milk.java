package decorator;

public class Milk extends CondimentDecorator {
	Beverage beverage;

	public Milk(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " Milk";
	}

	@Override
	public double cost() {		
		return beverage.cost() + 0.2;
	}

}
