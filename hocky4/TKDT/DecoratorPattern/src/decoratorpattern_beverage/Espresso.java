package decoratorpattern_beverage;

public class Espresso extends Beverage {
	private float price = 1.989f;

	public Espresso() {
		description = "Expresso";
	}

	@Override
	public float cost() {
		return price;
	}
}
