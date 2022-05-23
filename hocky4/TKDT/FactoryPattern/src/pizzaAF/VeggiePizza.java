package pizzaAF;

public class VeggiePizza extends Pizza {
	private PizzaIngredientFactory factory;

	public VeggiePizza(PizzaIngredientFactory factory) {
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
