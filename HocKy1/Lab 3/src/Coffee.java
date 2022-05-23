
public class Coffee {
private String kind;
private double price;
private double weight;
public Coffee (String kind, double price, double weight) {
	this.kind = kind;
	this.price = price;
	this.weight = weight;
	
}
//gia ban ra cua cafe
public double cost () {
	return (this.price * this.weight);
}
// ban hon gia 
public boolean priceOver (double amount) {
	return this.price > amount;
}
}
