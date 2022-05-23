package Execise4;

import Execise3.IGallery;

public abstract class AGroceryStore implements IGroceryStore {
	protected String brandName;
	protected int weight;
	protected int price;

	protected AGroceryStore(String brandName, int weight, int price) {
		super();
		this.brandName = brandName;
		this.weight = weight;
		this.price = price;
	}

// giá của 1 đơn vị
	public double unitPrice() {
		return this.price * this.weight;
	}

// kiểm tra xem có thấp hơn giá cho trước
	public boolean lowerPrice(double amount) {
		return this.unitPrice() < amount;
	}

// kiểm tra xem giá loại hàng có rẻ hơn so mới giá của loại khác
	public boolean cheaperThan(IGroceryStore other) {
		return this.unitPrice() < other.unitPrice();
	}
}
