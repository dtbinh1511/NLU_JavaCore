package travel_management;

import java.util.ArrayList;

public class Customer {
	private String name;
	private String phoneNumber;
	private String address;
	private String email;
	private int slot;
	private String payment;

	private ArrayList<Register> registers = new ArrayList<Register>();

	public Customer(String name, String phoneNumber, String address, String email, int slot, String payment) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.slot = slot;
		this.payment = payment;
	}

	// customer register

	public boolean register(Tour tour, Trip trip) {
		if (tour instanceof DomesticTour && trip.getDate() > 3) {
			registers.add(new Register(tour, trip));
			return true;
		}
		if (tour instanceof ForeignTour && trip.getDate() > 7) {
			registers.add(new Register(tour, trip));
			return true;
		}
		return false;
	}

	public String statement() {
		StringBuilder builder = new StringBuilder("name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + ", email=" + email + ", slot="
				+ slot + ", payment=" + payment + "\n");
		for (Register register : registers) {
			builder.append("Trip: "+register.getTrip().getDateStart());
		}
		return  builder.toString();
	}

	public ArrayList<Register> getRegisters() {
		return registers;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public int getSlot() {
		return slot;
	}

	public String getPayment() {
		return payment;
	}

}
