package NK7;

public class DomesticProduct  extends Product{

	public DomesticProduct(String id, int price, String name, Date productDate) {
		super(id, price, name, productDate);
	}
	public String toString() {
		return "DOMESTIC PRODUCT: " + "\n" + "    ID: " + this.id + "\n" + "    PRICE: " + this.price + "\n" + "    NAME: " + this.name + "\n" + "    PRODUCTDATE: "
				+ this.productDate ;
	}
}
