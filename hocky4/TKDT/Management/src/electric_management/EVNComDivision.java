package electric_management;

import java.util.*;

public class EVNComDivision {
	private String name;
	private Map<String, Customer> customers = new HashMap<String, Customer>();

	public EVNComDivision(String name) {
		super();
		this.name = name;
	}
	// add customer

	public void register(Customer customer) {
		customers.put(customer.getId(), customer);
	}

	public Customer getCustomer(String id) {
		return customers.get(id);
	}

	public String showByID(String id) {
		StringBuilder builder = new StringBuilder("Company " + name + "\n");
		builder.append("Bill cost electric of customer\n\n");
		builder.append(getCustomer(id).statement());
		return builder.toString();

	}

	public String allInvoice() {
		StringBuilder builder = new StringBuilder("Company " + name + "\n");
		for (Customer customer : customers.values()) {
			builder.append(customer.statement());
		}
		return builder.toString();
	}
}
