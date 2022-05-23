package decoratorpattern_beverage;

public class Mocha extends CondimentDecorator {
	private float price = 0.2f;

	public Mocha(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", mocha";
	}

	public float cost() {
		return beverage.cost() + price;
	}
}
