package payment;

public class Paypal implements Strategy {

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using Paypal.");
	}

}
