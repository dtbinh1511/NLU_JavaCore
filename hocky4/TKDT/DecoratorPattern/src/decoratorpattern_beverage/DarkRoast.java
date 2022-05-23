package decoratorpattern_beverage;

public class DarkRoast extends Beverage {

	private float price = 0.99f;

	public DarkRoast() {
		description = "Dark Roast coffee";
	}

	@Override
	public float cost() {
		return price;
	}
}
