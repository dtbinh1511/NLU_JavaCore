package Task2_1;

public class Juice extends AnItem {
	protected String flavor;
	protected String packaged;

	public Juice(String brandName, double weight, double price, String flavor, String packaged) {
		super(brandName, weight, price);
		this.flavor = flavor;
		this.packaged = packaged;
	}

	public String toString() {
		return "\n" + " Brand Name: " + this.brandName + "\n " +"Weight: " + this.weight + "\n " +"Price: "
				+ this.price + "\n " +"Flavor: " + this.flavor + "\n " +"Packaged: " + this.packaged + "\n";
	}

}
