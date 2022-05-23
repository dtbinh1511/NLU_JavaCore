package factory;

import java.util.ArrayList;

public abstract class Pizza {
	public String name;
	public String dough;
	public String sauce;
	public ArrayList<String> toppings = new ArrayList();

	public void prepare() {
		System.out.println("Preparing " + name);
		System.out.println("Tossing dough... " + dough);
		System.out.println("Add sauce... " + sauce);
		System.out.println("Add toppings: ");
		for (int i = 0; i < toppings.size(); i++) {
			System.out.println(" " + toppings.get(i));
		}
	}

	public void bake() {
		System.out.println("Baking " + name);
	}

	public void cut() {
		System.out.println("Cutting " + name);
	}

	public void box() {
		System.out.println("Boxing " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
