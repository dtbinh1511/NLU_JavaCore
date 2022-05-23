package payment;

import java.util.Date;

public class Customer {
	private String id;
	private String name;
	private Date dob;
	private String mobile;
	private String email;
	private String address;

	public Customer(String id, String name, Date dob, String mobile, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}
}
