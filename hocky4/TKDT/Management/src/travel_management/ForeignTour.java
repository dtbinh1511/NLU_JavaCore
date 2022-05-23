package travel_management;

public class ForeignTour extends Tour {
	private String fromCountry;
	private int visa;

	public ForeignTour(String name, String description, int numOfDay, double price, String fromCountry, int visa) {
		super(name, description, numOfDay, price);
		this.fromCountry = fromCountry;
		this.visa = visa;
	}

	@Override
	public String viewListTrip() {
		StringBuilder builder = new StringBuilder("Foreign Tour " + name + "\n");
		builder.append("List trip of foreign tour\n");
		for (int i = 0; i < trips.size(); i++) {

			builder.append((i + 1) + ", " + trips.get(i).getDateStart() + "\n");
		}
		return builder.toString();
	}

	@Override
	public String viewCustomerRegister() {
		StringBuilder builder = new StringBuilder("Foreign Tour " + name + "\n");
		for (int i = 0; i < customers.size(); i++) {

			builder.append((i + 1) + ", " + customers.get(i).statement() + "\n");
		}
		return builder.toString();
	}

	@Override
	public int totalIncome() {
		int result = 0;
		for (Customer customer : customers) {
			result += price * customer.getSlot() + visa * customer.getSlot();
		}
		return result;
	}
}
