package b8;

import java.util.Date;

public class The {
	private String maPM;
	private int ngayMuon;
	private int hanTra;
	private int soHieuSach;
	
	public The(String maPM, int ngayMuon, int hanTra, int soHieuSach) {
		super();
		this.maPM = maPM;
		this.ngayMuon = ngayMuon;
		this.hanTra = hanTra;
		this.soHieuSach = soHieuSach;
	}

	public String getMaPM() {
		return maPM;
	}

	public void setMaPM(String maPM) {
		this.maPM = maPM;
	}

	public int getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(int ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public int getHanTra() {
		return hanTra;
	}

	public void setHanTra(int hanTra) {
		this.hanTra = hanTra;
	}

	public int getSoHieuSach() {
		return soHieuSach;
	}

	public void setSoHieuSach(int soHieuSach) {
		this.soHieuSach = soHieuSach;
	}

	@Override
	public String toString() {
		return "The [maPM=" + maPM + ", ngayMuon=" + ngayMuon + ", hanTra=" + hanTra + ", soHieuSach=" + soHieuSach
				+ "]";
	}

}
