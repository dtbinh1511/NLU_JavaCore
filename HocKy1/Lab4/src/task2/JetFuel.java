package task2;

public class JetFuel {
	private int quantity; // gallons
	private String quanlityLevel;
	private int basePrice; // cents per gallon

	public JetFuel(int quantity, String quanlityLevel, int basePrice) {

		this.quantity = quantity;
		this.quanlityLevel = quanlityLevel;
		this.basePrice = basePrice;
	}
 
	public double totalCost() {
		return this.quantity * this.basePrice;

	}

	public double discountPrice() {
		if (this.totalCost() > 100000)
			return this.totalCost() * 0.1 ;
		else return this.totalCost();
	}
}
