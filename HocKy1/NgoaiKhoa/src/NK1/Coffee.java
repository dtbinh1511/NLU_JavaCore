package NK1;

public class Coffee {
	private String kind;
	private double price;
	private double weight;

	public Coffee(String kind, double price, double weight) {
		this.kind = kind;
		this.price = price;
		this.weight = weight;
	}

////Giá bán của cà phê
//	public double cost() {
//		return this.price * this.weight;
//	}

//Kiểm tra xem giá của cà có cao hơn số nhập vào
	public boolean priceOver(double amount) {
		return this.price > amount;
	}

	// Tính giảm giá của cà phê
	public double cost() {
		if (this.price * this.weight <= 5000)
			return 0;
		else if (this.price * this.weight <= 20000)
			return this.price * this.weight * 0.1;
		else
			return this.price * this.weight * 0.25;
	}
}
