package Execise1;

public class Truck extends AVihecle {
	private double loadInTons;

	protected Truck(double fuelTankVolume, double averageMilePerGallon, double loadInTons) {
		super(fuelTankVolume, averageMilePerGallon);
		this.loadInTons = loadInTons;
	}

	@Override
	public double fuelConsumption() {
		return this.averageMilePerGallon * (1 - 0.05 * this.loadInTons);
	}

	@Override
	public double howFar() {
		return this.fuelTankVolume * this.fuelConsumption();
	}

}
