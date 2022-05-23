package Task5;

public class Transaction {
	private String customerName;
	private int depositAmount; // dollar
	private int maturity; // Number year

	public Transaction(String customerName, int depositAmount, int maturity) {

		this.customerName = customerName;
		this.depositAmount = depositAmount;
		this.maturity = maturity;
	}
	/* The mothod interest consumes a deposit amount and produces the actual amount
 of interest that the money earns in a year */

	public double interest() {
		if (this.depositAmount < 1000)
			return this.depositAmount * 0.04;
		else if (this.depositAmount < 5000)
			return this.depositAmount * 0.045;
		else
			return this.depositAmount * 0.05;

	}
	/* The payback method computes the corresponding pay-back amount based on a charge
	  amount*/

	public double payback() {
		if (this.depositAmount <= 500)
			return this.depositAmount * 0.0025;
		else if (this.depositAmount <= 1500)
			return 500 * 0.0025 + (this.depositAmount - 500) * 0.0005;
		else if (this.depositAmount <= 2500)
			return 500 * 0.0025 + 1000 * 0.005 + (this.depositAmount - 1500) * 0.0075;
		else
			return 500 * 0.0025 + 1000 * 0.005 + 1000 * 0.0075 + (this.depositAmount - 2500) * 0.01;
	}
}
