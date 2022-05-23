package NK7;

public class ImportedProduct extends Product {
	private String importedCountry;

	public ImportedProduct(String id, int price, String name, Date productDate, String importedCountry) {
		super(id, price, name, productDate);
		this.importedCountry = importedCountry;
	}

	public String toString() {
		return "\n"+ "IMPORTED PRODUCT: " + "\n"+ "   IMPORTEDCOUNTRY: " + this.importedCountry + "\n" + "   ID: " + this.id + "\n" + "   PRICE: " + this.price
				+ "\n" + "   NAME: " + this.name +"\n" + "   PRODUCTDATE: " + this.productDate ;
	}

}
