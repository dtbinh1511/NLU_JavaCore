package pizzaSF1;

public class PizzaStore {
	private SimplePizzaSFactory factory;

	public PizzaStore(SimplePizzaSFactory factory) {
		super();
		this.factory = factory;
	}

	public Pizza orderPizza(String type) {
		Pizza pizza = factory.createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}
}
