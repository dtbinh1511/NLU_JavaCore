package prizzaFM;

public class NYStylePizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		if (type.equals("Cheese")) {
			return new NYStyleCheesePizza();
		}
		if (type.equals("Clam")) {
			return new NYStyleClamPizza();
		}
		if (type.equals("Veggie")) {
			return new NYStyleVeggiePizza();
		}
		if (type.equals("Pepperoni")) {
			return new NYStylePeperoniPizza();
		}
		return null;
	}

}
