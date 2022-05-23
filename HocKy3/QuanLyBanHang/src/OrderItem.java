
public class OrderItem {
	private Item item;
	private Integer quantity; // số lượng
	
	public OrderItem(Item item, Integer quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}


	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "OrderItem=" + item + ", quantity=" + quantity  ;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
