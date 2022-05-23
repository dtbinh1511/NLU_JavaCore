package Execise5;

public class Address {
	private int numberhouse;
	private String nameStreet;
	private String city;

	public Address(int numberhouse, String nameStreet, String city) {
		this.numberhouse = numberhouse;
		this.nameStreet = nameStreet;
		this.city = city;
	}

	// Kiểm tra xem cái địa chỉ này có nằm trong thành phố đó hay không?
	public boolean inThisCity(String city) {
		return this.city.equals(city);
	}

	// Kiểm tra xem ngôi nhà này và ngôi nhà khác có cùng chung một thành phố hay
	// không?
	public boolean sameCity(Address other) {
		return this.city.equals(city);

	}
}
