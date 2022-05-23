
public class QuanLyNCS {
	private String mNCS;
	private String hoTen;
	private Date date;
	private GiaoSu giaoSu1;
	private GiaoSu giaoSu2;

	public QuanLyNCS(String mNCS, String hoTen, Date date, GiaoSu giaoSu1, GiaoSu giaoSu2) {
		super();
		this.mNCS = mNCS;
		this.hoTen = hoTen;
		this.date = date;
		this.giaoSu1 = giaoSu1;
		this.giaoSu2 = giaoSu2;
	}

// Kiem tra xem 2 giao su co lam viec cung khoa khong?
	public boolean sameKhoa(GiaoSu other) {
		return this.giaoSu1.sameKhoa(this.giaoSu2);
	}

	// Kiem tra xem nghien cuu sinh nay co qua 35 tuoi khong
	public boolean tooAge35() {
		return this.date.tooAge35();
	}

}
