package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class OrderManager {
	private List<Order> orders = null;

	public OrderManager(List<Order> orders) {
		super();
		this.orders = orders;
	}

// top N hóa đơn có cost cao nhất
	public List<Order> getTopNOrders(int n) {
		List<Order> newList = new ArrayList<Order>();

		Collections.sort(orders, new Comparator<Order>() {

			@Override
			public int compare(Order o1, Order o2) {
				if (o1.cost() > o2.cost())
					return -1;
				return 1;
			}
		});
		for (int i = 0; i < n; i++) {
			newList.add(orders.get(i));
		}
		return newList;
	}

// số lượng bán ra nhiều nhất
//	public Product maxProduct() {
//
//	}
//
//	//
//	public List<Product> maxProducIsByTypes() {
//
//	}

	public static void main(String[] args) {
		Product p1 = new Product("a", "a", 1000.00, new Date(80));
		Product p2 = new Product("b", "b", 2000.00, new Date(80));
		Product p3 = new Product("c", "c", 4000.00, new Date(80));

		OrderItem orderItems1 = new OrderItem(p1, 3);
		OrderItem orderItems2 = new OrderItem(p2, 7);
		OrderItem orderItems3 = new OrderItem(p3, 1);

		List<OrderItem> list1 = new ArrayList<OrderItem>() {
		};
		List<OrderItem> list22 = new ArrayList<OrderItem>() {
		};
		list1.add(orderItems1);
		list22.add(orderItems2);
		list22.add(orderItems3);

		Order order1 = new Order("01", "ABC", "XYZ", new Date(25, 11, 2020), list1);
		Order order2 = new Order("02", "DEF", "XYZ", new Date(25, 11, 2020), list22);

		List<Order> order = new ArrayList<Order>() {
		};
		order.add(order1);
		order.add(order2);

		OrderManager manager = new OrderManager(order);

		System.out.println(manager.getTopNOrders(1));
	}
}
