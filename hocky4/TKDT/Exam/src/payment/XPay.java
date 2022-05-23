package payment;

public class XPay {
	private String customerName;
	private String creditCardNo;
	private String cardExpMonth;
	private String cardExpYear;
	private String cardCVVNo;
	private int amount;

	public XPay(String customerName, String creditCardNo, String cardExpMonth, String cardExpYear, String cardCVVNo,
			int amount) {
		super();
		this.customerName = customerName;
		this.creditCardNo = creditCardNo;
		this.cardExpMonth = cardExpMonth;
		this.cardExpYear = cardExpYear;
		this.cardCVVNo = cardCVVNo;
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getAmount() {
		return amount;
	}

	public void payment(ShoppingCart sc) {
		if (getCustomerName().equals(sc.getCustomer().getName()) && (getAmount() == sc.amount())) {
			System.out.println("Da thanh toan hoa don. Cam on quy khach da su dung dich vu");
			System.out.println("Tong hoa do cua ban la: " + sc.amount());
		} else {
			System.err.println("Kiem tra lai ten & so tien nhap");
		}
	}
}
