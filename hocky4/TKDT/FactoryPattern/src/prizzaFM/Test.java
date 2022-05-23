package prizzaFM;

public class Test {
	public static void main(String[] args) {
		PizzaStore nyStore = new NYStylePizzaStore();
		PizzaStore chicagoStore = new ChicagoStylePizzaStore();

		Pizza pizza = nyStore.orderPizza("Cheese");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = chicagoStore.orderPizza("Cheese");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");
		pizza = nyStore.orderPizza("Clam");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = chicagoStore.orderPizza("Clam");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");
		pizza = nyStore.orderPizza("Pepperoni");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = chicagoStore.orderPizza("Pepperoni");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");
		pizza = nyStore.orderPizza("Veggie");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");

		pizza = chicagoStore.orderPizza("Veggie");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

	}
}
