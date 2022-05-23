package decoratorpattern_beverage;

public class Decaf extends Beverage {

	private float price = 1.05f;

	public Decaf() {
		description = "Decaf coffee";
	}

	@Override
	public float cost() {
		return price;
	}
}
