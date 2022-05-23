package app_factorymethod;

public class TransportHCM extends Transport {

	@Override
	public Vehicle createVehicle(String type) {
		Vehicle vehicle = null;
		if (type.equalsIgnoreCase("bike")) {
			vehicle = new BikeHCM();
		} else if (type.equalsIgnoreCase("bus")) {
			vehicle = new BusHCM();
		}
		return vehicle;
	}

}
