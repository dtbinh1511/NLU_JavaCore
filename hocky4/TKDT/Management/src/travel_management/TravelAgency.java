package travel_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TravelAgency {
	private String name;
	private ArrayList<Tour> tours = new ArrayList<Tour>();
//	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private Map<Tour, Customer> map = new HashMap<Tour, Customer>();

	public TravelAgency(String name) {
		super();
		this.name = name;
	}

//	public void add(Tour tour) {
//		tours.add(tour);
//	}
	public void add(Tour tour, Customer customer) {
		map.put(tour, customer);
	}

	public String showListTour() {
		StringBuilder builder = new StringBuilder("Travel Agency " + name + " greetings to you \n");
		for (Entry<Tour, Customer> tour : map.entrySet()) {
			builder.append(tour.getKey().viewListTrip() + "\n");
		}
		return builder.toString();
	}

	public String showCustomer() {
		StringBuilder builder = new StringBuilder("Travel Agency " + name + " greetings to you \n");
		for (Entry<Tour, Customer> tour : map.entrySet()) {
			builder.append("---------------------------------\n");
			builder.append(tour.getKey().viewCustomerRegister() + "\n");
			builder.append("Total slot: " + tour.getKey().totalSlot() + "\n");
			builder.append("Total income: " + tour.getKey().totalIncome() + "\n");
		}
		return builder.toString();
	}
//	public String showTour() {
//		StringBuilder builder = new StringBuilder("Travel Agency " + name + " greetings to you \n\n");
//		for (Tour tour : tours) {
//			builder.append(tour.viewCustomerRegister()+"\n");
//		}
//		return builder.toString();
//	}
}
