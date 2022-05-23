package templatemethod;

public abstract class CaffeineBeverageWithHook {
	final void prepareRecipe() {
		boilWater();
		brew();
		pournlnCup();
		if (customerWantsCondiments())
			addCondiments();
	}

	protected void pournlnCup() {
		System.out.println("Pouring into cup");
	}

	protected void boilWater() {
		System.out.println("Boiling watter");
	}

	protected abstract void brew();

	protected abstract void addCondiments();

	public boolean customerWantsCondiments() {
		return true;
	}
}
