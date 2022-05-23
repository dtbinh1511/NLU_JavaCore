package payment;

public class AdapterXPay implements Bank {
	private XPay xPay;

	public AdapterXPay(XPay xPay) {
		this.xPay = xPay;
	}

	public void payment(ShoppingCart sc) {
		xPay.payment(sc);
	}

	@Override
	public int getAmount() {
		return xPay.getAmount();
	}
}
