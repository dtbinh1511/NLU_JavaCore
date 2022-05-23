package decoratorpattern_beverage;

public class HouseBlend extends Beverage {
	private float price = 0.89f;

	public HouseBlend() {
		description = "House Blend";
	}

	@Override
	public float cost() {
		return price;
	}

}
