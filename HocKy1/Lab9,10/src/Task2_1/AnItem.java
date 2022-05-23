package Task2_1;

public abstract class AnItem {
	protected String brandName;
	protected double weight;
	protected double price;

	public AnItem(String brandName, double weight, double price) {
		super();
		this.brandName = brandName;
		this.weight = weight;
		this.price = price;
	}

	public String toString() {
		return this.brandName + "" + this.weight + "" + this.price;
	}

	public int howMany() {
		return 1;
	}

	public String brandList() {
		return this.brandName;
	}

	public double getPrice() {
		return this.price ;
	}
}
