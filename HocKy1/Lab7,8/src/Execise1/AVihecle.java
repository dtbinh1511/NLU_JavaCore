package Execise1;

public abstract class AVihecle implements IVehicle {
	protected double fuelTankVolume; // in gallons
	protected double averageMilePerGallon;

	protected AVihecle(double fuelTankVolume, double averageMilePerGallon) {
		super();
		this.fuelTankVolume = fuelTankVolume;
		this.averageMilePerGallon = averageMilePerGallon;
	}

	public double refuelCost(double costPerGallon) {
		return costPerGallon * this.fuelTankVolume;
	}

	public abstract double fuelConsumption();

	public abstract double howFar();
}
