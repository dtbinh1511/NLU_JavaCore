package video_rental;

import java.util.ArrayList;
import java.util.Date;

public class Customer {
	private String name;
	private ArrayList<RentItem> rentals = new ArrayList<>();

	public Customer(String name) {
		super();
		this.name = name;
	}

	// add item
	public void rentMovie(Movie movie, Date startDate) {
		if (rentals.size() < 5)
			rentals.add(new RentItem(movie, startDate));
	}

	// remove item

	public void removeMovie(String name) {
		RentItem ri = null;
		for (RentItem rentItem : rentals) {
			if (rentItem.getMovie().getTitle().equals(name))
				ri = rentItem;
		}
		rentals.remove(ri);
	}

	public String statement() {
		StringBuilder builder = new StringBuilder("Name rental: " + name + "\n");

		for (RentItem rentItem : rentals) {
			builder.append("Title: " + rentItem.getMovie().getTitle() + ", price: " + rentItem.getChargeRent()
					+ ", point: " + rentItem.getFrequentRenterPoint() + "\n");
		}
		builder.append("Total charge: " + totalCharge() + " & Total point: " + totalPoint());
		return builder.toString();
	}

	private double totalPoint() {
		double result = 0;
		for (RentItem rentItem : rentals) {
			result += rentItem.getFrequentRenterPoint();
		}
		return result;
	}

	private double totalCharge() {
		double result = 0;
		for (RentItem rentItem : rentals) {
			result += rentItem.getChargeRent();
		}
		return result;
	}
}
