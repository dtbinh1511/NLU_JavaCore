package NK5;

public class Bill {
	private Date establishDate;
	private Infomation seller;
	private Infomation buyer;
	private IList listProduct;

	public Bill(Date establishDate, Infomation seller, Infomation buyer, IList listProduct) {
		super();
		this.establishDate = establishDate;
		this.seller = seller;
		this.buyer = buyer;
		this.listProduct = listProduct;
	}
	public double totalPrice() {
		return this.listProduct.totalPrice();
	}
	public String toString() {
		return "BILL" + "\n" 
			+"Day/Month/Year: " + this.establishDate + "\n" + "\n"
			+ "Infor of Seller: " + "\n" 
			+ this.seller + "\n" + "\n"
			+ "Infor of Buyer: "+ "\n" 
			+ this.buyer + "\n" +"\n"
			+ "List Product: " + this.listProduct + "\n" + "\n" 
			+ "Total Price: " + this.totalPrice();
}

}
