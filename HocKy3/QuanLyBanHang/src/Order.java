import java.util.ArrayList;

public class Order {
	private String id;
	private String date;
	private ArrayList<OrderItem> orderItemList = new ArrayList<>();

	public Order(String id, String date) {
		super();
		this.id = id;
		this.date = date;
	}

	public void addOrderItem(OrderItem oi) {
		orderItemList.add(oi);
	}

	/*
	 * C1 nộp: tính tổng số lượng sản phẩm đã mua Vd: mua 3 cây kẹo, 5 kem
	 * đánh răng => kết quả là mua 8 món
	 */
	public int getTotalQuantity() {
		int result = 0;
		for (OrderItem orderItem : orderItemList) {
			result += orderItem.getQuantity();
		}
		return result;

	}

	/*
	 * C2 nộp: tính tổng sản phẩm đã mua Vd: mua 3 cây kẹo, 5 kem đánh răng
	 * => kết quả là mua 2 sản phẩm
	 */
	public int getTotalItemQuantity() {
		return orderItemList.size();
	}

	/*
	 * tong tien cua hoa don
	 * 
	 */
	public int totalPayment() {
		int result = 0;
		for (OrderItem oi : orderItemList) {
			result += oi.getQuantity() * oi.getItem().getExportedPrice();
		}
		return result;
	}

	@Override
	public String toString() {
		return "OrdeId=" + id + ", date=" + date + ", orderItemList=" + orderItemList+"\n";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item it1 = new Item("1", "MiGoi", "ACECook", 2800, 3500);
		Item it2 = new Item("2", "KemDR", "Congate", 16500, 18500);
		Item it3 = new Item("3", "Keo", "PhamNguyen", 14500, 17600);
		Item it4 = new Item("4", "DauAn", "TuongAn", 28000, 32000);
		Item it5 = new Item("5", "NuocTuong", "Maggy", 18000, 27000);
		Item it6 = new Item("6", "TuongOt", "Cholimex", 8800, 9500);
		Item it7 = new Item("7", "TuongCa", "Cholimex", 8800, 9500);

		OrderItem oi11 = new OrderItem(it1, 10);
		OrderItem oi12 = new OrderItem(it2, 1);
		OrderItem oi13 = new OrderItem(it3, 3);
		OrderItem oi14 = new OrderItem(it4, 10);
		OrderItem oi15 = new OrderItem(it5, 5);
		OrderItem oi16 = new OrderItem(it6, 7);
		OrderItem oi17 = new OrderItem(it7, 8);

		Order or1 = new Order("ORDER_01", "25/11/2020");
		or1.addOrderItem(oi11);
		or1.addOrderItem(oi12);
		or1.addOrderItem(oi13);
		or1.addOrderItem(oi14);
		or1.addOrderItem(oi15);
		or1.addOrderItem(oi16);
		or1.addOrderItem(oi17);

		System.out.println(or1.totalPayment());
		System.out.println(or1.getTotalQuantity());
		System.out.println(or1.getTotalItemQuantity());
	}

}
