package pizzaSF1;

public class SimplePizzaSFactory {

	public Pizza createPizza(String type) {
		if (type.equals("Veggie"))
			return new VeggiePizza();
		if (type.equals("Clam"))
			return new ClamPizza();
		if (type.equals("Cheese"))
			return new ChessePizza();
		if (type.equals("Peperoni"))
			return new PeperoniPizza();
		return null;
	}

}
