package decoratorpattern_beverage;

public class Whip extends CondimentDecorator {

	private float price = 0.1f;

	public Whip(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", whip";
	}

	public float cost() {
		return beverage.cost() + price;
	}

}
