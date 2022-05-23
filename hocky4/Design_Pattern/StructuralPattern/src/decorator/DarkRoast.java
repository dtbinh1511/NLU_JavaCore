package decorator;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "dark roast coffee";
	}

	@Override
	public double cost() {
		return 1.59;
	}

}
