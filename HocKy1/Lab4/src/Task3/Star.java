package Task3;

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

//	public String getFirstName() {
//		return firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public String getInstrument() {
//		return instrument;
//	}

//so sanh doanh thu cua ngoi sao nay co lon hon ngoi sao khac
	public boolean biggerSales(Star that) {
		if (this.sales > that.sales)
			return true;
		else
			return false;
	}

// so sanh 2 ngoi sao co giong nhau hay khong
	public boolean same(Star orther) {
		return (this.firstName.equals(orther.firstName) && (this.lastName.equals(orther.lastName))
				&& (this.instrument.equals(orther.instrument)) && (this.sales == orther.sales));

//		if (this.firstName.equals(orther.firstName) && (this.lastName.equals(orther.lastName))
//				&& (this.instrument.equals(orther.instrument)) && (this.sales == orther.sales))
//			return true;
//		else return false;

	}

//public boolean equals(Star that) {
//	if (this.firstName.equals(that.firstName) && (this.lastName.equals(that.lastName))
//			&& (this.instrument.equals(that.instrument)) && (this.sales == that.sales))
//		;
//	return true;
//lay sales cua ngoi sao

	// dua ra so tien
	public int getSales() {
		return this.sales;

	}

// doanh thu cua ngoi sao tang 20000 nhung tren 1 ngoi sao khac
	public Star incrementSales() {
		return new Star(this.firstName, this.lastName, this.instrument, this.sales + 20000);

	}

// doanh thu cua ngoi sao tang 20000
	public void muatbleIncrementSales() {
		this.sales = this.sales + 20000;
	}

//	@Override
//	public String toString() {
//		return "Star [firstName=" + firstName + ", lastName=" + lastName + ", instrument=" + instrument + ", sales="
//				+ sales + "]";
//	}
//	
}
