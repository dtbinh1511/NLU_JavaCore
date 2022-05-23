package pizzaAF;

public interface PizzaIngredientFactory {
	public Dough createDough();

	public Sauce createSauce();

	public Veggie[] createVeggies();

	public Cheese createCheese();

	public Pepperoni createPepperoni();

	public Clam createClams();
}
