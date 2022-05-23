package Execise4;

public class IceCream extends AGroceryStore{
	private String glavor;
	private String packaged;
	protected IceCream(String brandName, int weight, int price, String glavor, String packaged) {
		super(brandName, weight, price);
		this.glavor = glavor;
		this.packaged = packaged;
	}
}
