package payment;

public class Test {
	public static void main(String[] args) {
		Item i1 = new Item("0", 15);
		Item i2 = new Item("0", 45);
		Item i3 = new Item("0", 25);
		Item i4 = new Item("0", 30);

		ShoppingCart sc = new ShoppingCart(new Paypal());
		sc.addItem(i1);
		sc.addItem(i2);
		sc.addItem(i3);
		sc.addItem(i4);
		
		sc.pay();
		
		ShoppingCart sc1 = new ShoppingCart(new CreditsCard());
		sc1.addItem(i1);
		sc1.addItem(i2);
		sc1.addItem(i3);
		
		sc1.pay();
	}
}
