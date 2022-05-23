
public class Coffee {
	private String kind;
	private int price;
	private int weight;

	public Coffee(String kind, int price, int weight) {

		this.kind = kind;
		this.price = price;
		this.weight = weight;
	}

	public double cost() {
		if (this.price * this.weight < 5000)
			return (this.price * this.weight);
		else if (this.price * this.weight <= 20000)
			return (this.price * this.weight * (1 - 0.1));
		else
			return (this.price * this.weight * (1 - 0.25));
	}
}
