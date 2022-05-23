package b15_bo;

import java.util.ArrayList;

public class QuanLySV {
	private ArrayList<Khoa> dsKhoa;

	public QuanLySV() {
		this.dsKhoa = new ArrayList<Khoa>();
	}

	public int tongSVChinhQuy(String tenKhoa) {
		int sum = 0;
		for (Khoa khoa : dsKhoa) {
			if (khoa.getTenKhoa().equals(tenKhoa)) {
				for (SinhVien sv : khoa.getDanhSachSV()) {
					if (sv instanceof SinhVienChinhQuy)
						sum++;
				}
			}
		}
		return sum;
	}

	public ArrayList<SinhVien> getSVTaiChuc(String noiDaoTao) {
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		for (Khoa khoa : dsKhoa) {
			for (SinhVien sinhVien : khoa.getDanhSachSV()) {
				if (sinhVien instanceof SinhVienTaiChuc
						&& ((SinhVienTaiChuc) sinhVien).getNoiDaoTao().equals(noiDaoTao)) {
					list.add(sinhVien);
				}
			}
		}
		return list;
	}
}
