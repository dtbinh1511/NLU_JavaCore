package app_factorymethod;

public class TransportHaNoi extends Transport {

	@Override
	public Vehicle createVehicle(String type) {
		Vehicle vehicle = null;
		if (type.equalsIgnoreCase("bus")) {
			vehicle = new BusHaNoi();
		}
		return vehicle;
	}
}
