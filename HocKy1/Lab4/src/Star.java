
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

	public boolean biggerSales(Star that) {
		if (this.sales > that.sales)
			return true;
		else
			return false;
	}

	public boolean same(Star that) {
		return (this.firstName.equals(that.firstName) && (this.lastName.equals(that.lastName))
				&& (this.instrument.equals(that.instrument)) && (this.sales == that.sales));

	}

	public boolean equals(Star that) {
		if (this.firstName.equals(that.firstName) && (this.lastName.equals(that.lastName))
				&& (this.instrument.equals(that.instrument)) && (this.sales == that.sales))
			;
		return true;

	}
}
