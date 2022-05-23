package NK5;

public class Infomation {
	private String name;
	private String address;

	public Infomation(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String toString() {
		return "Name: " + this.name +"\n"+
			 "Address: " + this.address;
	}
}
