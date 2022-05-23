package prizzaFM;

public class ChicagoStylePizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		if (type.equals("Cheese")) {
			return new ChicagoStyleCheesePizza();
		}
		if (type.equals("Clam")) {
			return new ChicagoStyleClamPizza();
		}
		if (type.equals("Veggie")) {
			return new ChicagoStyleVeggiePizza();
		}
		if (type.equals("Pepperoni")) {
			return new ChicagoStylePeperoniPizza();
		}
		return null;
	}

}
