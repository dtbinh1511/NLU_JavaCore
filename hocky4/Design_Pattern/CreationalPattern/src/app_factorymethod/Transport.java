package app_factorymethod;

public abstract class Transport {
	public abstract Vehicle createVehicle(String type);

	public Vehicle orderVehicle(String type) {
		Vehicle vehicle = createVehicle(type);
		vehicle.refueling();
		return vehicle;
	}
}
