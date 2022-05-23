package Set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class GioHang {
	private TreeSet<MatHang> gio = new TreeSet<MatHang>();

	public GioHang() {
		super();
	}

	// thêm mặt hàng vào giỏ
	public void add(MatHang mh) {
		gio.add(mh);
	}

	// xóa mặt hàng khỏi giỏ
	public void remove(MatHang mh) {
		gio.remove(mh);
	}

	// tìm kiếm mặt hàng dựa vào tên
	public MatHang find(String tenMH) {
		for (MatHang matHang : gio) {
			if (matHang.getTenMH().equals(tenMH))
				return matHang;
		}
		return null;
	}

	// tìm kiếm mặt hàng dựa vào ký tự
	public List<MatHang> find(char c) {
		List<MatHang> list = new ArrayList<>();
		for (MatHang matHang : gio) {
			char[] chars = matHang.getTenMH().toCharArray();
			if (chars[0] == c)
				list.add(matHang);
		}
		return list;
	}

	// lấy ra số lượng sản phẩm lớn hơn 2
	public List<MatHang> getAmountGreaterThan2() {
		List<MatHang> list = new ArrayList<>();
		for (MatHang matHang : gio) {
			if (matHang.getSoluong() > 2)
				list.add(matHang);
		}
		return list;

	}

	// thêm mặt hàng, nếu trùng thì tăng số lượng
	public void addSpecial(MatHang mh) {
		Iterator<MatHang> iter = gio.iterator();
		while (iter.hasNext()) {
			MatHang next = iter.next();
			if (next.compareTo(mh) == 0) {
				next.setSoluong(next.getSoluong() + mh.getSoluong());
			}
		}
		if (!gio.contains(mh)) { // dùng compareTo nên chỉ so với maMH
			gio.add(mh);
		}
	}

	// xóa mặt hàng, nếu có sl > hơn thì sửa lại sl, sl< báo lỗi
	public void removeSpecial(MatHang mh) {
		Iterator<MatHang> iter = gio.iterator();
		while (iter.hasNext()) {
			MatHang next = iter.next();
			if (next.compareTo(mh) == 0 && next.getSoluong() > mh.getSoluong()) {
				next.setSoluong(next.getSoluong() - mh.getSoluong());
				break;
			}
			if (next.compareTo(mh) == 0 && next.getSoluong() == mh.getSoluong()) {
				gio.remove(mh);
				break;
			} else if (next.compareTo(mh) == 0 && next.getSoluong() < mh.getSoluong()) {
				System.err.println("Lỗi");
				break;
			}
		}
	}

	// tính giá trị của giỏ
	public int total() {
		Iterator<MatHang> iter = gio.iterator();
		int sum = 0;
		while (iter.hasNext()) {
			MatHang next = iter.next();
			sum += next.getSoluong() * next.getDongia();
		}
		return sum;
	}

	public String toString() {
		return gio.toString() + "\nTổng giá trị giỏ: " + total();
	}

	public static void main(String[] args) {
		MatHang mh1 = new MatHang("1", "a", 1000, 1);
		MatHang mh2 = new MatHang("2", "b", 2000, 4);
		MatHang mh3 = new MatHang("3", "c", 3000, 6);
		MatHang mh4 = new MatHang("4", "d", 4000, 2);

		GioHang gioHang = new GioHang();
		gioHang.add(mh1);
		gioHang.add(mh2);
		gioHang.add(mh3);
		gioHang.add(mh4);
		System.out.println(gioHang.toString());
		System.out.println("=========================");
//		gioHang.remove(mh1);
//		System.out.println(gioHang.toString());
//		System.out.println(gioHang.find("d"));

//		for (MatHang s : gioHang.find('b')) {
//			System.out.println(s);
//		}

//		for (MatHang s : gioHang.getAmountGreaterThan2()) {
//			System.out.println(s);
//		}
		MatHang mh5 = new MatHang("4", "d", 4000, 1);
		MatHang mh6 = new MatHang("5", "d", 4000, 1);

		gioHang.addSpecial(mh6);
//		gioHang.addSpecial(mh5);

//		gioHang.removeSpecial(mh5);
		System.out.println(gioHang.toString());
	}
}
