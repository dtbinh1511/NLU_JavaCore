package payment;

public class PayD implements Bank {
	private String custCardNo;
	private String cardOwnerName;
	private String cardExxpMonthDate;
	private String CVVNo;
	private int totalAmount;

	public PayD(String custCardNo, String cardOwnerName, String cardExxpMonthDate, String cVVNo, int totalAmount) {
		super();
		this.custCardNo = custCardNo;
		this.cardOwnerName = cardOwnerName;
		this.cardExxpMonthDate = cardExxpMonthDate;
		this.CVVNo = cVVNo;
		this.totalAmount = totalAmount;
	}

	public String getCardOwnerName() {
		return cardOwnerName;
	}

	public int getAmount() {
		return totalAmount;
	}

	public void payment(ShoppingCart sc) {
		if (getCardOwnerName().equals(sc.getCustomer().getName()) && (getAmount() == sc.amount())) {
			System.out.println("Da thanh toan hoa don. Cam on quy khach da su dung dich vu");
			System.out.println("Tong hoa do cua ban la: " + sc.amount());
		} else {
			System.err.println("Kiem tra lai ten & so tien nhap");
		}
	}
}
