package NK1;

public class CD {
private String owmer;
private int amount;
public CD(String owmer, int amount) {
	super();
	this.owmer = owmer;
	this.amount = amount;
}
//Tính lãi suất khi mua CD
public double interest() {
	if (this.amount <= 5000)
	return this.amount * 0.02;
	else if (this.amount <= 10000)
		return this.amount * 0.0225;
	else return this.amount * 0.025;
}
}
