package factory;

public class ChicagoStylePizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if (type.equalsIgnoreCase("cheese")) {
			pizza = new ChicagoStyleCheesePizza();
		} else if (type.equalsIgnoreCase("clam")) {
			pizza = new ChicagoStyleClamPizza();
		}
		return pizza;
	}

}
