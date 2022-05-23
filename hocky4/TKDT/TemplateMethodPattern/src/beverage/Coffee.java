package beverage;

public class Coffee extends CoffeinBeverage {

	@Override
	public void brew() {
		System.out.println("Dripping Coffee through fitter");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}

}
