package NK5;

public class Product {
protected Size size;
protected String kindWood;
protected int unitPrice;
public Product(Size size, String kindWood, int unitPrice) {
	super();
	this.size = size;
	this.kindWood = kindWood;
	this.unitPrice = unitPrice;
}
public String toString() {
	return  "\n"+ "Size: " + this.size + "\n"
			+ "Kind Wood: " + this.kindWood + "\n"
			+ "Unit Price: " + this.unitPrice +" dollar";
	
}
public double totalPrice () {
	return  this.unitPrice ;
}
}
