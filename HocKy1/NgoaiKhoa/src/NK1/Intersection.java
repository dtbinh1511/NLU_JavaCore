package NK1;

public class Intersection {
private int avenue, street;

public Intersection(int avenue, int street) {
	super();
	this.avenue = avenue;
	this.street = street;
}
public boolean closeTo(Intersection other) {
	if (Math.abs(this.avenue - other.avenue) <= 1 && Math.abs(this.street - other.street) <= 1) 
			return true;
	else return false;
}
}
