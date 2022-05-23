import java.util.ArrayList;
import java.util.HashMap;

public class Store {
	private String id;
	private String name;
	private ArrayList<Order> orderList = new ArrayList<>();

	public Store(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/*
	 * Them 1 don hang
	 */
	public void addOrder(Customer c, Order or) {
		c.add(or);
		orderList.add(or);
	}

	@Override
	public String toString() {
		return "StoreId=" + id + ", name=" + name + "\n" + orderList + "\n";
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		else {
			Store that = (Store) obj;
			return this.id.equals(that.id) && this.name.equals(that.name) && this.orderList.equals(that.orderList);
		}
	}

	/*
	 * Tim ra don hang co tri gia lon nhat
	 */
	public Order getMaxTotalPaymentOrder() {
		Order result = null;
		int maxTotalPayment = 0;
		for (Order or : orderList) {
			if (or.totalPayment() > maxTotalPayment) {
				maxTotalPayment = or.totalPayment();
				result = or;
			}
		}
		return result;
	}

	/*
	 * C3: Tìm ra những hóa đơn có trị giá lớn hơn tri giá trung bình HINT:
	 * có thể viết thêm hàm hõ trợ tính trị giá trung bình của hóa đơn
	 */
	public ArrayList<Order> getOrderGreaterAverageTotalPayment() {
		ArrayList<Order> result = new ArrayList<Order>();
		for (Order order : orderList) {
			if (order.totalPayment() > getAverageTotalPayment())
				result.add(order);
		}
		return result;

	}

	public double getAverageTotalPayment() {
		double result = 0.0;
		for (Order or : orderList) {
			result += or.totalPayment();
		}
		return result / orderList.size();
	}

	/*
	 * Thong ke theo ten Mh, tong so luong ban ra
	 */
	public HashMap<String, Integer> nameItem_TotalQuantity_Statistic() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for (Order or : orderList) {
			for (OrderItem oi : or.getOrderItemList()) {
				String nameItem = oi.getItem().getName();
				if (result.containsKey(nameItem)) {
					result.put(nameItem, result.get(nameItem) + oi.getQuantity());
				} else {
					result.put(nameItem, oi.getQuantity());
				}
			}

		}
		return result;
	}

	/*
	 * C4: Thong ke theo ten nha san xuat, tong so luong ban ra
	 */
	public HashMap<String, Integer> production_TotalQuantity_Statistic() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for (Order or : orderList) {
			for (OrderItem oi : or.getOrderItemList()) {
				String nameProduction = oi.getItem().getProduction();
				if (result.containsKey(nameProduction)) { // tồn tại trong list thì tăng số lượng
					result.put(nameProduction, result.get(nameProduction) + oi.getQuantity());
				} else { // ko có thì add
					result.put(nameProduction, oi.getQuantity());
				}
			}
		}
		return result;
	}

	/*
	 * Tiền lời cua cua hang
	 */
	public int interest() {
		int result = 0;
		for (Order or : orderList) {
			for (OrderItem oi : or.getOrderItemList()) {
				result += oi.getQuantity() * (oi.getItem().getExportedPrice() - oi.getItem().getImportedPrice());
			}
		}
		return result;
	}

	public static void main(String[] args) {
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
//		or1.addOrderItem(oi14);
//		or1.addOrderItem(oi15);
//		or1.addOrderItem(oi16);
//		or1.addOrderItem(oi17);

		Order or2 = new Order("ORDER_02", "25/11/2020");
		or2.addOrderItem(new OrderItem(it1, 24));// 16800
		
		Order or3 = new Order("ORDER_03", "25/11/2020");
		or3.addOrderItem(new OrderItem(it2, 4));
		
		Store store = new Store("V001", "Vinmart");
		store.addOrder(new Customer("B01", "Đỗ Bình", "Đống Đa - Hà Nội"), or1);
		store.addOrder(new Customer("D01", "Nhật Đức", "Hoàn Kiếm - Hà Nội"), or2);
		store.addOrder(new Customer("T01", "Anh Thư", "Hoàn Kiếm - Hà Nội"), or3);
//		System.out.println(store.production_TotalQuantity_Statistic());

		System.out.println(store.getOrderGreaterAverageTotalPayment());
		System.out.println(store.getAverageTotalPayment());
//		System.out.println(store.interest());
	}

}
