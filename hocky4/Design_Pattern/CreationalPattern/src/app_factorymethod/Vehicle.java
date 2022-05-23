package app_factorymethod;

public class Vehicle {
	protected String name;
	
	public void refueling() {
		System.out.println("Dang do xang cho: "+ name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
