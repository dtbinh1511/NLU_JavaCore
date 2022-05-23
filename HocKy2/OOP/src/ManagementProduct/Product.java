package ManagementProduct;

public class Product {
	String name;
	String decription;
	double cost;

	void showProduct() {
		System.out.println("Name Product: " + name);
		System.out.println("Deciption Product: " + decription);
		System.out.println("Cost Product: " + cost);

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public String getDecription() {
		return decription;
	}

	public double getCost() {
		return cost;
	}

}
