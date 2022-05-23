package b15_bo;

import java.util.ArrayList;

public class Khoa {
	private String tenKhoa;
	private ArrayList<SinhVien> danhSachSV;

	public Khoa(String tenKhoa) {
		super();
		this.tenKhoa = tenKhoa;
		this.danhSachSV = new ArrayList<SinhVien>();
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	public ArrayList<SinhVien> getDanhSachSV() {
		return danhSachSV;
	}

	public void setDanhSachSV(ArrayList<SinhVien> danhSachSV) {
		this.danhSachSV = danhSachSV;
	}

	@Override
	public String toString() {
		return "Khoa [tenKhoa=" + tenKhoa + ", danhSachSV=" + danhSachSV + "]";
	}

	public boolean themSV(SinhVien sv) {
		for (SinhVien sinhVien : danhSachSV) {
			if (!sinhVien.getMaSV().equals(sv.getMaSV())) {
				danhSachSV.add(sinhVien);
				return true;
			}
		}
		return false;
	}

	public float getDiemTB(String mssv, int hocKy) {
		for (SinhVien sinhVien : danhSachSV) {
			if (sinhVien.getMaSV().equals(mssv)) {
				for (KetQuaHocTap kq : sinhVien.getList()) {
					if (kq.getHocKy() == hocKy) {
						return kq.getDiemTrungBinh();
					}
				}
			}
		}
		return 0;
	}

	
}
