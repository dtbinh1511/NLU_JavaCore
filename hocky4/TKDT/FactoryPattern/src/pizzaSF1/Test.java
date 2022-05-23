package pizzaSF1;

public class Test {
	public static void main(String[] args) {
		SimplePizzaSFactory factory = new SimplePizzaSFactory();

		PizzaStore store = new PizzaStore(factory);

		Pizza pizza = store.orderPizza("Cheese");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza.toString());

		pizza = store.orderPizza("Veggie");
		System.out.println("We ordered a " + pizza.getName() + "\n");
		System.out.println(pizza.toString());

	}
}
