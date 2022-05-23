package beverage_with_hook;

public abstract class CoffeinBeverageWithHooks {
	public final void prepareRecipe() {
		boilWater();
		brew();
		pourlnCup();
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}

	public void boilWater() {
		System.out.println("Boiling water");
	}

	public void pourlnCup() {
		System.out.println("Pouring into cup");
	}

	public abstract void brew();

	public abstract void addCondiments();

	public boolean customerWantsCondiments() {
		return true;
	}
}
