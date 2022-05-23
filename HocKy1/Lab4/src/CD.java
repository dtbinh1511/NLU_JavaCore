
public class CD {
	private String owner;
	private int amount; // cents

	public CD(String owner, int amount) {

		this.owner = owner;
		this.amount = amount;
	}

	public double interest() {
		if (this.amount <= 5000)
			return this.amount * 0.02;
		else if (this.amount <= 10000)
			return this.amount * 0.025;
		else
			return this.amount * 0.25;
	}
}
