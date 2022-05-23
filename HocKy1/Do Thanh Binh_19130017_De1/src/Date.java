
public class Date {
	private int ngay;
	private int thang;
	private int nam;

	public Date(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

// Kiem tra xem NCS co hon 35 tuoi khong
	public boolean tooAge35() {
		if (this.nam - 1984 > 0)
			return false;
		else
			return true;
	}
}
