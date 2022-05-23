package travel_management;

import java.util.Iterator;

public class DomesticTour extends Tour {

	public DomesticTour(String name, String description, int numOfDay, double price) {
		super(name, description, numOfDay, price);
	}

	@Override
	public String viewListTrip() {
		StringBuilder builder = new StringBuilder("Domestic Tour " + name + "\n");
		builder.append("List trip of domestic tour\n");
		for (int i = 0; i < trips.size(); i++) {

			builder.append((i + 1) + ", " + trips.get(i).getDateStart() + "\n");
		}
		return builder.toString();

	}

	@Override
	public String viewCustomerRegister() {
		StringBuilder builder = new StringBuilder("Domestic Tour " + name + "\n");
		for (int i = 0; i < customers.size(); i++) {

			builder.append((i + 1) + ", " + customers.get(i).statement() + "\n");
		}
		return builder.toString();
	}

	@Override
	public int totalIncome() {
		int result = 0;
		for (Customer customer : customers) {
			result += price * customer.getSlot();
		}
		return result;
	}

}
