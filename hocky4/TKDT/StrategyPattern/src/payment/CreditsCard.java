package payment;

public class CreditsCard implements Strategy {

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid with credit/debit card");
	}

}
