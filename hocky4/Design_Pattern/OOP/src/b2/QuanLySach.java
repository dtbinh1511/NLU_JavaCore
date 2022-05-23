package b2;

import java.util.ArrayList;

public class QuanLySach {
	private ArrayList<TaiLieu> list;

	public QuanLySach() {
		list = new ArrayList<TaiLieu>();
	}

	public boolean add(TaiLieu tl) {
		for (TaiLieu taiLieu : list) {
			if (!taiLieu.getMaTaiLieu().equals(tl)) {
				list.add(taiLieu);
				return true;
			}
		}
		return false;
	}

	public boolean delete(String maTL) {
		for (TaiLieu taiLieu : list) {
			if (taiLieu.getMaTaiLieu().equals(maTL)) {
				list.remove(taiLieu);
				return true;
			}
		}
		return false;
	}

	public String print() {
		StringBuilder builder = new StringBuilder();
		for (TaiLieu taiLieu : list) {
			builder.append(taiLieu.toString());
		}
		return builder.toString();
	}

	public ArrayList<TaiLieu> searchByBook() {
		ArrayList<TaiLieu> list = new ArrayList<TaiLieu>();
		for (TaiLieu taiLieu : list) {
			if (taiLieu instanceof Sach)
				list.add(taiLieu);
		}
		return list;
	}

	public ArrayList<TaiLieu> searchByNewspaper() {
		ArrayList<TaiLieu> list = new ArrayList<TaiLieu>();
		for (TaiLieu taiLieu : list) {
			if (taiLieu instanceof Bao)
				list.add(taiLieu);
		}
		return list;
	}

	public ArrayList<TaiLieu> searchByTapChi() {
		ArrayList<TaiLieu> list = new ArrayList<TaiLieu>();
		for (TaiLieu taiLieu : list) {
			if (taiLieu instanceof TapChi)
				list.add(taiLieu);
		}
		return list;
	}
}