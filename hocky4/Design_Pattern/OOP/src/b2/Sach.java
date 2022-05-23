package b2;

public class Sach extends TaiLieu {
	private String tenTG;
	private int soTrang;

	public Sach(String maTaiLieu, String tenNXB, int soPH, String tenTG, int soTrang) {
		super(maTaiLieu, tenNXB, soPH);
		this.tenTG = tenTG;
		this.soTrang = soTrang;
	}

	public String getTenTG() {
		return tenTG;
	}

	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	@Override
	public String toString() {
		return super.toString() + "Bao [tenTG=" + tenTG + ", soTrang=" + soTrang + "]";
	}
}
