package Task2_1;

public class Coffee extends AnItem {
	protected String label;

	public Coffee(String brandName, double weight, double price, String label) {
		super(brandName, weight, price);
		this.label = label;
	}

	public String toString() {
		return "\n" + " Brand Name: " + this.brandName + "\n " +"Weight: " + this.weight + "\n " +"Price: "
				+ this.price + "\n " +"Label: " + this.label + "\n";	}
}
