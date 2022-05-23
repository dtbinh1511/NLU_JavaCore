package decoratorpattern_beverage;

public class Soy extends CondimentDecorator {

	private float price = 0.15f;

	public Soy(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", soy";
	}

	public float cost() {
		return beverage.cost() + price;
	}

}
