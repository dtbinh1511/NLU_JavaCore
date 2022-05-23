package payment;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Customer c = new Customer("A", "A", new Date(), "0123232", "dsada@gmail.com", "tpHCM");
		Customer c2 = new Customer("A", "B", new Date(), "0123232", "dsada@gmail.com", "tpHCM");

		Product p1 = new Product("01", "Sua rua mat", 100000);
		Product p2 = new Product("02", "Khan tam", 50000);
		Product p3 = new Product("03", "Khan rua mat", 40000);
		Product p4 = new Product("04", "But chi", 20000);
		Product p5 = new Product("05", "Ban chai danh rang", 30000);

		ShoppingCart sc = new ShoppingCart(c);
		sc.addProduct(p5);
		sc.addProduct(p4);
		sc.addProduct(p3);
		sc.addProduct(p2);
		sc.addProduct(p1);
		sc.removeProduct(p1);

		ShoppingCart sc1 = new ShoppingCart(c2);
		sc1.addProduct(p5);

		XPay xPay = new XPay("B", "20132213231", "10", "2021", "231", 30000);
		Bank payD = new PayD("01A", "A", "10", "231", 140000);
		Bank adapterPay = new AdapterXPay(xPay);

		payD.payment(sc);
		adapterPay.payment(sc1);
	}
}
