package ThayToan;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CongTyNhanSu {
	public ArrayList<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();

//	public ArrayList<NhanVien> getDanhSachNhanVien() {
//		return danhSachNhanVien;
//	}
//
//	public void setDanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien) {
//		this.danhSachNhanVien = danhSachNhanVien;
//	}

	public void themNhanVien(NhanVien nhanVien) {
		if (danhSachNhanVien.contains(nhanVien))
//			JOptionPane.showMessageDialog(null, "Nhan vien da ton tai");
			System.out.println("Nhan vien da ton tai");
		else
			danhSachNhanVien.add(nhanVien);

	}

	public void xoaNhanVien() {
		danhSachNhanVien.removeAll(danhSachNhanVien);
	}

	public void xemDanhSach() {
		for (NhanVien nhanVien : danhSachNhanVien) {
			System.out.println(nhanVien);
		}
	}

	public static void main(String[] args) {
		CongTyNhanSu nhanSu = new CongTyNhanSu();
		NhanVien nv1 = new NhanVien("001", "Binh", "15/11/2001", "Nam", "5.000.000");
		NhanVien nv2 = new NhanVien("002", "Toan", "15/11/2001", "Nam", "5.000.000");
		NhanVien nv3 = new NhanVien("001", "Binh", "15/11/2001", "Nam", "5.000.000");

		nhanSu.themNhanVien(nv1);
		nhanSu.themNhanVien(nv2);
		nhanSu.themNhanVien(nv3);

	}

}
