package beverage;

public class Test {
	public static void main(String[] args) {
		CoffeinBeverage beverage = new Coffee();
		beverage.prepareRecipe();
		System.out.println("-------------------");
		beverage = new Tea();
		beverage.prepareRecipe();
	}
}
