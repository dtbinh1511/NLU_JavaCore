package pizzaAF;

public class PepperoniPizza extends Pizza {
	private PizzaIngredientFactory factory;

	public PepperoniPizza(PizzaIngredientFactory factory) {
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
