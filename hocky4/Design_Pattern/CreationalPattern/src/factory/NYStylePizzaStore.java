package factory;

public class NYStylePizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equalsIgnoreCase("cheese")) {
			pizza = new NYStyleCheesePizza();
		} else if (type.equalsIgnoreCase("clam")) {
			pizza = new NYStyleClamPizza();
		}
		return pizza;
	}

}
