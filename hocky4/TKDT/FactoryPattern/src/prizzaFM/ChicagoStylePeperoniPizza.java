package prizzaFM;

public class ChicagoStylePeperoniPizza extends Pizza {
	public ChicagoStylePeperoniPizza() {
		 name = "Chicago Style Pepperoni Pizza";
		 dough = "Extra Thick Crust Dough";
		 sauce = "Plum Tomato Sauce";

		 toppings.add("Shredded Mozzarella Cheese");
		 toppings.add("Black Olives");
		 toppings.add("Spinach");
		 toppings.add("Eggplant");
		 toppings.add("Sliced Pepperoni");
		 }

	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}

}
