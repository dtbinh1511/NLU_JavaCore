package payment;

import java.util.ArrayList;

public class ShoppingCart {
	private Customer customer;
	private ArrayList<Product> products = new ArrayList<>();

	public ShoppingCart(Customer customer) {
		super();
		this.customer = customer;
	}

	public void addProduct(Product p) {
		products.add(p);
	}

	public void removeProduct(Product p) {
		products.remove(p);
	}

	public int amount() {
		int total = 0;
		for (Product product : products) {
			total += product.getPrice();
		}

		return total;
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
