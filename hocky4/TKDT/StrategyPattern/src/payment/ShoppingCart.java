package payment;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Item> items = new ArrayList<>();
	private Strategy strategy;

	public ShoppingCart(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

	public int calculate() {
		int sum = 0;
		for (Item item : items) {
			sum += item.getPrice();
		}
		return sum;
	}

	public void pay() {
		strategy.pay(calculate());
	}
}
