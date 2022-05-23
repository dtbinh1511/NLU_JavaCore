package b5;

import java.util.ArrayList;

public class KhachSan {
	private ArrayList<Nguoi> ds;

	public KhachSan() {
		ds = new ArrayList<Nguoi>();
	}

	public boolean add(Nguoi n) {

		return ds.add(n);

	}

	public boolean delete(int cmnd) {
		for (Nguoi nguoi : ds) {
			if (nguoi.getCmnd() == cmnd) {
				return ds.remove(nguoi);
			}
		}
		return false;
	}

	public int thanhTien(long cmnd) {
		for (Nguoi nguoi : ds) {
			if (nguoi.getCmnd() == cmnd) {
				return nguoi.getSoNgayThue() * nguoi.getPhong().getGia();
			}
		}
		return 0;
	}

	public String show() {
		StringBuilder builder = new StringBuilder();
		for (Nguoi nguoi : ds) {
			builder.append(nguoi.toString());
		}

		return builder.toString();
	}
}
