package List;

import java.util.Date;
import java.util.List;

public class Order {
	private String id;
	private String customer;
	private String employee;
	private Date date;
	private List<OrderItem> items = null;

	public Order(String id, String customer, String employee, Date date, List<OrderItem> items) {
		super();
		this.id = id;
		this.customer = customer;
		this.employee = employee;
		this.date = date;
		this.items = items;
	}

	public double cost() {
		double sum = 0.0;
		for (int i = 0; i < items.size(); i++) {
			sum += items.get(i).cost();
		}
		return sum;
	}

	public int maxProduct() {
		OrderItem orderItem = items.get(0);
		int sum = 0;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).isProduct(orderItem)) {
				sum += items.get(i).getN() + orderItem.getN();
			}
		}
		return sum;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", employee=" + employee + ", date=" + date + ", items="
				+ items + "\n";
	}

}
