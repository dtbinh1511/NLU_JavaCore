package payment;

public interface Bank {
	public void payment(ShoppingCart sc);
	public int getAmount();
}
