package b2;

import java.util.Date;

public class Bao extends TaiLieu {
	private int ngayPH;

	public Bao(String maTaiLieu, String tenNXB, int soPH, int ngayPH) {
		super(maTaiLieu, tenNXB, soPH);
		this.ngayPH = ngayPH;
	}

	public int getNgayPH() {
		return ngayPH;
	}

	public void setNgayPH(int ngayPH) {
		this.ngayPH = ngayPH;
	}

	@Override
	public String toString() {
		return super.toString() + "Bao [ngayPH=" + ngayPH + "]";
	}

}
