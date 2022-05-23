package b15_bo;

import java.util.ArrayList;
import java.util.Date;

public class SinhVien {
	private String maSV;
	private String hoTen;
	private Date ngaySinh;
	private int namVaoHoc;
	private float diemDauVao;
	private ArrayList<KetQuaHocTap> list;

	public SinhVien(String maSV, String hoTen, Date ngaySinh, int namVaoHoc, float diemDauVao) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.namVaoHoc = namVaoHoc;
		this.diemDauVao = diemDauVao;
		this.list = new ArrayList<KetQuaHocTap>();
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getNamVaoHoc() {
		return namVaoHoc;
	}

	public void setNamVaoHoc(int namVaoHoc) {
		this.namVaoHoc = namVaoHoc;
	}

	public float getDiemDauVao() {
		return diemDauVao;
	}

	public void setDiemDauVao(float diemDauVao) {
		this.diemDauVao = diemDauVao;
	}

	public ArrayList<KetQuaHocTap> getList() {
		return list;
	}

	public void setList(ArrayList<KetQuaHocTap> list) {
		this.list = list;
	}

	public boolean themKetQua(KetQuaHocTap kq) {
		return list.add(kq);
	}

}
