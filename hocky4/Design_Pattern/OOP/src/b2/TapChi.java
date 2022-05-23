package b2;

public class TapChi extends TaiLieu {
	private int soPH;
	private int thangPH;

	public TapChi(String maTaiLieu, String tenNXB, int soPH, int soPH2, int thangPH) {
		super(maTaiLieu, tenNXB, soPH);
		soPH = soPH2;
		this.thangPH = thangPH;
	}

	public int getSoPH() {
		return soPH;
	}

	public void setSoPH(int soPH) {
		this.soPH = soPH;
	}

	public int getThangPH() {
		return thangPH;
	}

	public void setThangPH(int thangPH) {
		this.thangPH = thangPH;
	}

	@Override
	public String toString() {
		return super.toString() + "TapChi [soPH=" + soPH + ", thangPH=" + thangPH + "]";
	}

}
