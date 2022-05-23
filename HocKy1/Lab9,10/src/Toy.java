
public class Toy {
	private String name;
	public double price;
	protected int available;

	public Toy(String name, double price, int available) {

		this.name = name;
		this.price = price;
		this.available = available;
	}

	public String toString() {
		return "\n" + "Name Toy: " + this.name + "\n" + "Price: " + this.price + "\n" + "Available: " + this.available
				+ "\n";
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Toy))
			return false;
		else {
			Toy other = (Toy) obj;
			return this.name.equals(other.name) && this.price == other.price && this.available == other.available;
		}
	}

	public boolean isName(String toyName) {
		return this.name.equals(toyName);
	}

	public boolean isBelowPrice(double threshold) {
		return this.price < threshold;

	}

	public Toy copyWithRaisePrice() {
		return new Toy(this.name, this.price * (1 + 0.05), this.available);
	}

	public void getNewPrice() {
		this.price = this.price * (1 + 0.05);
	}

	public void replaceName(String newName) {
		this.name = newName;
	}

	public String getName() {
		return this.name;
	}

	public int compareTo(Toy that) {
		return this.name.compareTo(that.name);
	}

	public double getPrice() {
		return this.price;
	}

	public boolean hasLowerPrice(Toy that) {
		return this.price < that.price;

	}
}
