
public class GiaoSu {
	private String mVC;
	private String hoTen;
	private int namSinh;
	private String khoa;

	public GiaoSu(String mVC, String hoTen, int namSinh, String khoa) {
		this.mVC = mVC;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.khoa = khoa;
	}

// kiem tra xem 2 giao su co lam viec cung khoa khong?
	public boolean sameKhoa(GiaoSu other) {
		return this.khoa.equals(other.khoa);
	}
}
