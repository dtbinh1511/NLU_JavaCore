package electric_management;

import java.util.*;

public abstract class Customer {
	protected String name;
	protected String id;

	public Customer(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Reading getNewReading() {
		return getReading().get(getReading().size() - 1);
	}

	public Reading getOldReading() {
		return getReading().get(getReading().size() - 2);
	}

	public abstract List<? extends Reading> getReading();

	public abstract double charge();

	public abstract String statement();

	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id;
	}

}
