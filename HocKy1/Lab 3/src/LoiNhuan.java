
public class LoiNhuan {
	private int soKhach;
	private int giaVe;
	private int tieuTon;

	public LoiNhuan(int soKhach, int giaVe, int tieuTon) {

		this.soKhach = soKhach;
		this.giaVe = giaVe;
		this.tieuTon = tieuTon;
	}

	public double tienLoi() {
		return (this.soKhach * this.giaVe) * 0.5 - 20;
	}
}
