package app_factorymethod;

public class BusHaNoi extends Vehicle {
	public BusHaNoi() {
		name = "xe bus o ha noi";
	}
	
	@Override
	public void refueling() {
		System.out.println("Cay xang ngung ban");
	}
}
