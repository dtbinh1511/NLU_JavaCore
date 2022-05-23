package pizzaAF;

public class CheesePizza extends Pizza {
	private PizzaIngredientFactory factory;

	public CheesePizza(PizzaIngredientFactory factory) {
		super();
		this.factory = factory;
	}

	public void prepare() {
		System.out.println("Preparing " + name);
		dough = factory.createDough();
		sauce = factory.createSauce();
		cheese = factory.createCheese();
		veggies = factory.createVeggies();
		pepperoni = factory.createPepperoni();
	}
}
