
public class House {
private String kind;
private int numberRooms;
private int price;
private Address address;
public House(String kind, int numberRooms, int price, Address address) {
	super();
	this.kind = kind;
	this.numberRooms = numberRooms;
	this.price = price;
	this.address = address;
}
// Kiểm tra xem số phòng của ngồi nhà này có hơn số phòng của ngôi nhà khác hay không?
public boolean hasMoreRooms (House orther) {
	return (this.numberRooms > orther.numberRooms);
}
//kiểm tra xem ngôi nhà có thuộc cái thành phố  này hay không?
public boolean inThisCity(String city) {
	return this.address.inThisCity(city);	
	
}
//kiểm tra xem một ngôi nhà với ngôi nhà khác có ở cùng một thành phố hay không
	public boolean sameCity(House other) {
		return this.address.sameCity(address);
		
	}
}
