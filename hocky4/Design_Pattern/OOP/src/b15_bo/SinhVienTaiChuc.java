package b15_bo;

import java.util.Date;

public class SinhVienTaiChuc extends SinhVien {
	private String noiDaoTao;

	public SinhVienTaiChuc(String maSV, String hoTen, Date ngaySinh, int namVaoHoc, float diemDauVao,
			String noiDaoTao) {
		super(maSV, hoTen, ngaySinh, namVaoHoc, diemDauVao);
		this.noiDaoTao = noiDaoTao;
	}

	public String getNoiDaoTao() {
		return noiDaoTao;
	}

	public void setNoiDaoTao(String noiDaoTao) {
		this.noiDaoTao = noiDaoTao;
	}

	@Override
	public String toString() {
		return "SinhVienTaiChuc [noiDaoTao=" + noiDaoTao + ", getMaSV()=" + getMaSV() + ", getHoTen()=" + getHoTen()
				+ ", getNgaySinh()=" + getNgaySinh() + ", getNamVaoHoc()=" + getNamVaoHoc() + ", getDiemDauVao()="
				+ getDiemDauVao() + ", getList()=" + getList() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
