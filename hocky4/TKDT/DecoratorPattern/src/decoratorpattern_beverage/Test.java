package decoratorpattern_beverage;

public class Test {
	public static void main(String[] args) {
		Beverage beverage = new HouseBlend();

		beverage = new Soy(beverage);
		beverage = new Milk(beverage);
		beverage = new Mocha(beverage);
		beverage = new Whip(beverage);

		System.out.println(beverage.cost());
		System.out.println(beverage.getDescription()); // note getDescription
	}
}
