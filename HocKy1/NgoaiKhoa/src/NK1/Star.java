package NK1;

public class Star {
	private String firstName;
	private String lastName;
	private String instrument;
	private int sales;

	public Star(String firstName, String lastName, String instrument, int sales) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.instrument = instrument;
		this.sales = sales;
	}

//Kiểm tra xem doanh thu của ngồi sao  này có lớn hơn doanh thu của ngôi sao khác không?
	public boolean biggerSales(Star other) {
		return this.sales > other.sales;
	}

//Kiểm tra xem 2 ngôi sao này có giống nha không?
	public boolean same(Star other) {
		return this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName)
				&& this.instrument.equals(other.instrument) && this.sales == other.sales;
	}
	//Doanh thu lấy ra 
	public int getSales() {
		return this.sales ;
	}
	// Trả về một ngôi sao khác có doanh thu tăng lên 20000 sử dụng muatable
	public Star incrementSales() {
		return new Star (this.firstName, this.lastName, this.instrument, this.sales + 20000);
		
	}
	// Trả về một ngôi sao có doanh thu tăng lên 20000 sử dụng immuatable
	
	public void muatbleIncrementSales() {
		this.sales = this.sales + 20000;
	}
}
