package beverage_with_hook;

public class Test {
	public static void main(String[] args) {
		CoffeinBeverageWithHooks beverage = new CoffeeWithHooks();
		beverage.prepareRecipe();
		beverage = new TeaWithHooks();
		beverage.prepareRecipe();
	}
}
