package Execise3;

public class Intersection {
	private int avenue;
	private int street;

	public Intersection(int avenue, int street) {
		super();
		this.avenue = avenue;
		this.street = street;
	}

// tinh xem 2 dia chi co gan nhau hay khong
public boolean closeTo(Intersection that) {
	if ((Math.abs(this.avenue - that.avenue) <= 1) && (Math.abs(this.street - that.street) <= 1))
	return true;
	else return false;
}
}
