package NK1;

public class JetJuel {
	private int quantitySold;
	private String qualityLevel;
	private int basePrice;

	public JetJuel(int quantitySold, String qualityLevel, int basePrice) {
		super();
		this.quantitySold = quantitySold;
		this.qualityLevel = qualityLevel;
		this.basePrice = basePrice;
	}

//T�nh gi� b�n
	public double totalCost() {
		return this.basePrice * this.quantitySold;
	}

//T�nh gi� b�n khi mua tr�n 1000000
	public double discountPrice() {
		if (this.quantitySold >= 100000)
			return this.quantitySold * this.basePrice *(1 -0.1);
		else
			return this.quantitySold * this.basePrice;
	}
}
