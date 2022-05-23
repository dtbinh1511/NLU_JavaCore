package pizzaAF;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Veggie[] createVeggies() {
		Veggie veggie[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggie;
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clam createClams() {
		return new FreshClam();
	}

}
