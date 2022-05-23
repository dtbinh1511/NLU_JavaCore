package b2;

public class TaiLieu {
	private String maTaiLieu;
	private String tenNXB;
	private int soPH;

	public TaiLieu(String maTaiLieu, String tenNXB, int soPH) {
		super();
		this.maTaiLieu = maTaiLieu;
		this.tenNXB = tenNXB;
		this.soPH = soPH;
	}

	public String getMaTaiLieu() {
		return maTaiLieu;
	}

	public void setMaTaiLieu(String maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}

	public String getTenNXB() {
		return tenNXB;
	}

	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}

	public int getSoPH() {
		return soPH;
	}

	public void setSoPH(int soPH) {
		this.soPH = soPH;
	}

	@Override
	public String toString() {
		return "TaiLieu [maTaiLieu=" + maTaiLieu + ", tenNXB=" + tenNXB + ", soPH=" + soPH + "]";
	}

}
