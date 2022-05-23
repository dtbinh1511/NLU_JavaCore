
public class Transaction {
	private String customerName;
	private double depositAmount; // dollar
	private int maturity; // Number year

	public Transaction(String customerName, int depositAmount, int maturity) {

		this.customerName = customerName;
		this.depositAmount = depositAmount;
		this.maturity = maturity;
	}
	// the method interest consumes a deposit amount and produces the actual mount
	// of interest that the money earns in a year

	public double interest() {
		if (this.depositAmount < 1000)
			return this.depositAmount * 0.04;
		else if (this.depositAmount <= 5000)
			return this.depositAmount * 0.045;
		else
			return this.depositAmount * 0.05;

	}
	// The payback method computes the corresponding pay-back amount based on a
	// charge amount

	public double payback() {
		if (this.depositAmount <= 500)
			return this.depositAmount * 0.25;
		else if (this.depositAmount <= 1000)
			return 500 * 0.25 + (this.depositAmount - 500) * 0.5;
		else
			return 500 * 0.25 + 1000 * 0.5 + 1000 * 0.75 + (this.depositAmount - 2500) * 0.011;

	}
}
