package finalAHung;

public class ConsRentItems implements IRentItems {
	private RentItem first;
	private IRentItems rest;
	public ConsRentItems(RentItem first, IRentItems rest) {
		super();
		this.first = first;
		this.rest = rest;
	}
	
}
