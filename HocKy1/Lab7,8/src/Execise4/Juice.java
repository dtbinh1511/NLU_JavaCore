package Execise4;

public class Juice extends AGroceryStore{
private String glavor;
private String packaged;
protected Juice(String brandName, int weight, int price, String glavor, String packaged) {
	super(brandName, weight, price);
	this.glavor = glavor;
	this.packaged = packaged;
}


}
