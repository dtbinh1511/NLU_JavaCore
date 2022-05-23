import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Company {
	private String name;
	private ArrayList<Store> storeList = new ArrayList<>();
	private ArrayList<Customer> customerList = new ArrayList<>();

	public Company(String name) {
		super();
		this.name = name;
	}

	public void addCuaHang(Store ch) {
		storeList.add(ch);
	}

	public void addKhachHang(Customer kh) {
		customerList.add(kh);
	}

	public String getTen() {
		return name;
	}

	public void setTen(String ten) {
		this.name = ten;
	}

	public ArrayList<Store> getListCuaHang() {
		return storeList;
	}

	public void setListCuaHang(ArrayList<Store> listCuaHang) {
		this.storeList = listCuaHang;
	}

	public ArrayList<Customer> getListKhachHang() {
		return customerList;
	}

	public void setListKhachHang(ArrayList<Customer> listKhachHang) {
		this.customerList = listKhachHang;
	}

	/*
	 * C7: Hàm trả về tên cửa hàng, tổng trị giá đơn hàng(doanh thu) của
	 * cửa hàng
	 */
	public HashMap<String, Integer> statisticNameStore_Income() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for (Store store : storeList) {
			result.put(store.getName(), store.interest());
		}
		return result;

	}

	/*
	 * C8: Hàm trả về khách hàng, điểm tích lũy của khách hàng được sắp
	 * xếp từ cao đến thấp theo điểm tích lũy
	 */
	public TreeSet<Customer> sortCustomerDESCByAcumulateMark() {
		TreeSet<Customer> result = new TreeSet<Customer>(new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				int result = Double.compare(o2.getAccumulateMark(), o1.getAccumulateMark());
				if (result == 0)
					return o2.getFullName().compareTo(o1.getFullName());
				return result;
			}
		});
		result.addAll(getListKhachHang());
		return result;

	}

	/*
	 * C9: Hàm trả về tổng lợi nhuận của công ty
	 */
	public int getTotalInterest() {
		int result = 0;
		for (Store store : storeList) {
			result += store.interest();
		}
		return result;

	}

	/*
	 * C10: Hàm trả về danh sách các cửa hàng có doanh thu thấp hơn giá
	 * trị nhận vào
	 */
	public ArrayList<Store> getStoreLessThanLimitIncome(int limit) {
		ArrayList<Store> result = new ArrayList<Store>();
		for (Store store : storeList) {
			if(store.interest()< limit)
				result.add(store);
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
		or1.addOrderItem(oi14);
		or1.addOrderItem(oi15);
		or1.addOrderItem(oi16);
		or1.addOrderItem(oi17);

		Order or2 = new Order("ORDER_02", "25/11/2020");
		or2.addOrderItem(new OrderItem(it1, 24));

		Customer customer1 = new Customer("B01", "Đỗ Bình", "Đống Đa - Hà Nội");
		Customer customer2 = new Customer("D01", "Nhật Đức", "Hoàn Kiếm - Hà Nội");

		Store store1 = new Store("V001", "Vinmart");
		store1.addOrder(customer1, or1);
		store1.addOrder(customer2, or2);
		Store store2 = new Store("V002", "Vincom");
		store2.addOrder(customer1, or1);
		store2.addOrder(customer2, or1);

		Company company = new Company("Vingroup");
		company.addCuaHang(store1);
		company.addCuaHang(store2);
		company.addKhachHang(customer1);
		company.addKhachHang(customer2);

		System.out.println("Tổng doanh thu các cửa hàng: "+company.statisticNameStore_Income());
		System.out.println("Điểm tích lũy :\n"+company.sortCustomerDESCByAcumulateMark());
		System.out.println("Tổng doanh thu của công ty: "+company.getTotalInterest());
		System.out.println(company.getStoreLessThanLimitIncome(150000));
	}

}
