package NK4;

public class Milk {
	private String name;
	private int weight;
	private int price;
	private Specification specification;
	private Manufactor manufactor;
	private Date productionDate;
	private Date expiredDate;

	public Milk(String name, int weight, int price, Specification specification, Manufactor manufactor,
			Date productionDate, Date expiredDate) {
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.specification = specification;
		this.manufactor = manufactor;
		this.productionDate = productionDate;
		this.expiredDate = expiredDate;
	}

	// Kiểm tra xem hộp sữa có được sản xuất ở 1 quốc gia cho trước hay không?
	public boolean inCountry(String country) {
		return this.manufactor.inCountry("Viet Nam");
	}

	// Thể tích hộp sữa
	public double volumn() {
		return this.specification.volumn();
	}

	// kiểm tra xem thể tích của hộp sữa có nhỏ hơn so với hộp sữa khác
	public boolean lessThan(Milk other) {
		return this.specification.lessThan(specification);
	}

	// kiểm tra xem có hộp sữa có trước thời gian sản xuất ko
	public boolean before(Date other) {
		return this.productionDate.before(other);
	}

	// kiểm tra xem hộp sữa đã hết hạn
	public boolean isExpired() {
		return this.expiredDate.before(new Date(7, 11, 2019));
	}

	// tính giảm giá
	public double discount() {
		if (this.productionDate.before(new Date(1, 1, 2017)))
			return this.price * 0.25;
		else if (this.productionDate.before(new Date(1, 6, 2018)))
			return this.price * 0.15;
		else
			return 0;
	}
}
