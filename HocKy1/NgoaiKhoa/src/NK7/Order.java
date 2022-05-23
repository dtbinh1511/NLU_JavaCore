package NK7;

public class Order {
	private String name;
	private Date created;
	private IList orderItem;

	public Order(String name, Date created, IList orderItem) {
		super();
		this.name = name;
		this.created = created;
		this.orderItem = orderItem;
	}

	public String toString() {
		return "CustomerName: " + this.name + "\n" + "CreatedDate: " + this.created + "\n" + "OrderItem: "
				+ this.orderItem + "Total Price: " + this.totalPrice() +"$" + "\n"+ "Contains product is my ba mien???" + "      "+this.contains("My ba mien");
	}
public double totalPrice() {
	return this.orderItem.totalPrice();
}
public boolean contains(String productName) {
	return this.orderItem.contains(productName);
}
}
