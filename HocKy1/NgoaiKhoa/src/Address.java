
public class Address {
private int numberhouse;
private String streetName;
private String city;
public Address(int numberhouse, String streetName, String city) {
	super();
	this.numberhouse = numberhouse;
	this.streetName = streetName;
	this.city = city;
}

// Kiểm tra xem 2 ngôi nhà có cùng một thành phố không?
public boolean inThisCity(String city) {
	if (this.city.equals(city))
		return true;
	else return false;
}
// Kiểm tra xem thành phố này có giống nhau hay không?
public boolean sameCity(Address other) {
return this.city.equals(other.city);
}
}
