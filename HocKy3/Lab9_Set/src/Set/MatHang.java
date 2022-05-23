package Set;

public class MatHang implements Comparable<MatHang> {
	private String maMH;
	private String tenMH;
	private int dongia;
	private int soluong;

	public MatHang(String maMH, String tenMH, int dongia, int soluong) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.dongia = dongia;
		this.soluong = soluong;
	}

	@Override
	public String toString() {
		return "MatHang [maMH=" + maMH + ", tenMH=" + tenMH + ", dongia=" + dongia + ", soluong=" + soluong + "\n";
	}

	public String getTenMH() {
		return tenMH;
	}

	public int getDongia() {
		return dongia;
	}

	public int getSoluong() {
		return soluong;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	@Override
	public int compareTo(MatHang o) {
		if (this.maMH.compareTo(o.maMH) > 0)
			return this.maMH.compareTo(o.maMH);
		if (this.tenMH.compareTo(o.tenMH) > 0)
			return this.tenMH.compareTo(o.tenMH);
		return this.dongia - o.dongia;
	}

	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		else {
			MatHang that = (MatHang) obj;
			return (this.maMH.equals(that.maMH) && this.tenMH.equals(that.tenMH) && this.dongia == that.dongia
					&& this.soluong == that.soluong);
		}
	}
}
