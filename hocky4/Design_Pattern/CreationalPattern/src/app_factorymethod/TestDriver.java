package app_factorymethod;

public class TestDriver {
	public static void main(String[] args) {
		Transport transportHN = new TransportHaNoi();
		Transport transportHCM = new TransportHCM();
		
		Vehicle vehicle = transportHCM.orderVehicle("bike");
		System.out.println(vehicle.getName() + "\n");
		
		vehicle = transportHCM.orderVehicle("bus");
		System.out.println(vehicle.getName() + "\n");
		
		vehicle = transportHN.orderVehicle("bus");
		System.out.println(vehicle.getName() + "\n");
	}
}
