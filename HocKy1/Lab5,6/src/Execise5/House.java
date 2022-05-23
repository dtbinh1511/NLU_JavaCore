package Execise5;

public class House {
	private String kind;
	private int numberRooms;
	private int price;
	private Address address;

	public House(String kind, int numberRooms, int price, Address address) {
		this.kind = kind;
		this.numberRooms = numberRooms;
		this.price = price;
		this.address = address;
	}

//Kiểm tra xem số phòng của nhà này có hơn số phòng của nhà khác hay không?
	public boolean hasMoreRooms(House other) {
		return this.numberRooms > other.numberRooms;
	}

//Kiểm tra xem ngôi nhà có ở cùng 1 thành phố hay không?
	public boolean inThisCity(String city) {
		return this.address.inThisCity(city);
	}

//Kiểm tra xem ngồi nhà này có cùng thành phố với ngôi nhà khác hay không?
	public boolean sameCity(House other) {
		return this.address.sameCity(address);
	}
}
