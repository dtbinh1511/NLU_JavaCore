package b15_bo;

import java.util.Date;

public class SinhVienChinhQuy extends SinhVien {

	public SinhVienChinhQuy(String maSV, String hoTen, Date ngaySinh, int namVaoHoc, float diemDauVao) {
		super(maSV, hoTen, ngaySinh, namVaoHoc, diemDauVao);
	}

	@Override
	public String toString() {
		return "SinhVienChinhQuy [getMaSV()=" + getMaSV() + ", getHoTen()=" + getHoTen() + ", getNgaySinh()="
				+ getNgaySinh() + ", getNamVaoHoc()=" + getNamVaoHoc() + ", getDiemDauVao()=" + getDiemDauVao()
				+ ", getList()=" + getList() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
