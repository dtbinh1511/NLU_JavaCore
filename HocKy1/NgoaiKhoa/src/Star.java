
public class Star {
	private String fisrtName;
	private String lastName;
	private String instrument;
	private int sales;

	public Star(String fisrtName, String lastName, String instrument, int sales) {
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.instrument = instrument;
		this.sales = sales;
	}
// mot ngoi sao moi co doanh thu tang len 20000
	public Star icrementSales() {
		return new Star(this.fisrtName, this.lastName, this.instrument, this.sales = this.sales + 20000);

	}
//doanh thu cua ngoi sao tang len 20000
	public void mutableIncrementSales() {
		this.sales = this.sales + 20000;
	}
// so tien lay ra
	public int getSales() {
		return this.sales;
	}
// so sanh hai ngoi sao co giong nhau khong
	public boolean same(Star orther) {
		return (this.fisrtName.equals(orther.fisrtName) &&
				this.lastName.equals(orther.lastName) && 
				this.instrument.equals(orther.instrument) &&
			 this.sales == orther.sales);

	}
}
