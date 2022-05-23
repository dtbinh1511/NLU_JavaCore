package Execise4;

public class Coffee extends AGroceryStore {
private String label;

protected Coffee(String brandName, int weight, int price, String label) {
	super(brandName, weight, price);
	this.label = label;
}
}
