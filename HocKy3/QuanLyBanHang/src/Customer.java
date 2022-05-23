import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Customer {
	private String id;
	private String fullName;
	private String address;
	private double accumulateMark = 0.0;
	private ArrayList<Order> orderList = new ArrayList<>();

	public Customer(String id, String fullName, String address) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAccumulateMark() {
		return accumulateMark;
	}

	public void setAccumulateMark(double accumulateMark) {
		this.accumulateMark = accumulateMark;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

//	@Override
//	public String toString() {
//		return "id=" + id + ", Customer=" + fullName + ", add=" + address;
//	}

	public String toString() {
		return fullName + " _ điểm tích lũy: " + accumulateMark + "\n";
	}

	/*
	 * Them don hang vao don hang cua khach hang, cap nhat diem tich luy
	 */
	public void add(Order order) {
		// TODO Auto-generated method stub
		orderList.add(order);
		// cap nhat diem tich luy biet rang dtl = dtl cu + trigia don hang chia 50.000
		double newPoints = this.accumulateMark + order.totalPayment() / 50000;
		this.setAccumulateMark(newPoints);
	}

//	 C5: Thống kê san pham va luot mua 
//	 HD1: 3 keo, 5 danhrang 
//	 HD2: 2 keo 
//	 HD3: 1 keo, 1 danhrang 
//	 ==> Kqua là keo 3 danhrang 2
//	 
	public HashMap<Item, Integer> item_NumberOfPurchase() {
		HashMap<Item, Integer> result = new HashMap<Item, Integer>();
		for (Order or : orderList) {
			for (OrderItem oi : or.getOrderItemList()) {
				Item item = oi.getItem();
				if (result.containsKey(item))
					result.put(item, result.get(item) + 1);
				else
					result.put(item, 1);
			}
		}
		return result;
	}

//	C6: Cac san pham duoc khach hang mua nhieu lan nhat 
//	 HD1: 3 keo, 5 danhrang
//	 HD2: 2 keo
//	 HD3: 1 keo, 1 danhrang 
//	 ==> Kqua là Keo (mua 3 lần)

	public ArrayList<Item> favoriteItem() {
		ArrayList<Item> result = new ArrayList<>();
		int max = 0;
		for (Entry<Item, Integer> item : item_NumberOfPurchase().entrySet()) {
			if (item.getValue() > max) {
				max = item.getValue();
			}
		}
		for (Entry<Item, Integer> item : item_NumberOfPurchase().entrySet()) {
			if (item.getValue() == max) {
				result.add(item.getKey());
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
		or1.addOrderItem(oi14);// thiếu phương thức add

		Order or2 = new Order("ORDER_02", "25/11/2020");
		or2.addOrderItem(new OrderItem(it1, 24));// 16800

		Order or3 = new Order("ORDER_03", "25/11/2020");
		or3.addOrderItem(new OrderItem(it2, 4));

		Customer customer = new Customer("B01", "Đỗ Bình", "Đống Đa - Hà Nội");
		customer.add(or1);
		customer.add(or2);
		customer.add(or3);
		System.out.println(customer.item_NumberOfPurchase());
		System.out.println(customer.favoriteItem());
	}

}
