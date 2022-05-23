package beverage;

public abstract class CoffeinBeverage {
	public final void prepareRecipe() {
		boilWater();
		brew();
		pourlnCup();
		addCondiments();
	}

	public void boilWater() {
		System.out.println("Boiling water");
	}

	public void pourlnCup() {
		System.out.println("Pouring into cup");
	}

	public abstract void brew();

	public abstract void addCondiments();
}
