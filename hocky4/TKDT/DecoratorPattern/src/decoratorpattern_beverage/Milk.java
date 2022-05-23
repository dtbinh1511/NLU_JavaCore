package decoratorpattern_beverage;

public class Milk extends CondimentDecorator {
	private float price = 0.1f;

	public Milk(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", milk";
	}

	@Override
	public float cost() {
		return beverage.cost() + price;
	}
}
