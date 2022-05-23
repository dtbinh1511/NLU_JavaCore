package travel_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Tour {
	protected String name;
	protected String description;
	protected int numOfDay;
	protected double price;
	protected ArrayList<Trip> trips = new ArrayList<Trip>();
	protected ArrayList<Customer> customers = new ArrayList<Customer>();
//	private Map<Customer, Trip> trips = new HashMap<Customer, Trip>();

	public Tour(String name, String description, int numOfDay, double price) {
		super();
		this.name = name;
		this.description = description;
		this.numOfDay = numOfDay;
		this.price = price;
	}

	// add Trip
	public void addTrip(Trip trip) {
		trips.add(trip);
	}

	// add Customer
	public void add(Customer customer) {
		for (int i = 0; i < customer.getRegisters().size(); i++) {
			if (customer.getRegisters().get(i).getTour() instanceof DomesticTour
					&& customer.getRegisters().get(i).getTrip().equals(trips.get(i))) {
				customers.add(customer);
			} else if (customer.getRegisters().get(i).getTour() instanceof ForeignTour
					&& customer.getRegisters().get(i).getTrip().equals(trips.get(i))) {

				customers.add(customer);
			}
		}
	}

	// print tour

	public ArrayList<Trip> getTrips() {
		return trips;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public abstract String viewListTrip();

	public abstract String viewCustomerRegister();

	public int totalSlot() {
		int total = 0;
		for (Customer customer : customers) {
			total += customer.getSlot();
		}
		return total;
	}

	public abstract int totalIncome();
}
