package b5;

public class Nguoi {
	private String hoTen;
	private int tuoi;
	private long cmnd;
	private int soNgayThue;
	private Phong phong;

	public Nguoi(String hoTen, int tuoi, long cmnd, int soNgayThue, Phong phong) {
		super();
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.cmnd = cmnd;
		this.soNgayThue = soNgayThue;
		this.phong = phong;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public long getCmnd() {
		return cmnd;
	}

	public void setCmnd(long cmnd) {
		this.cmnd = cmnd;
	}

	public int getSoNgayThue() {
		return soNgayThue;
	}

	public void setSoNgayThue(int soNgayThue) {
		this.soNgayThue = soNgayThue;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	@Override
	public String toString() {
		return "Nguoi [hoTen=" + hoTen + ", tuoi=" + tuoi + ", cmnd=" + cmnd + ", soNgayThue=" + soNgayThue + ", phong="
				+ phong + "]";
	}

}
