package Execise1;

public class Car extends AVihecle {
	private int nPassengers;

	protected Car(double fuelTankVolume, double averageMilePerGallon, int nPassengers) {
		super(fuelTankVolume, averageMilePerGallon);
		this.nPassengers = nPassengers;
	}



	@Override
	public double fuelConsumption() {
		return this.averageMilePerGallon * (1 - 0.1 * this.nPassengers);
	}

	@Override
	public double howFar() {
		return this.fuelTankVolume * this.fuelConsumption();
	}

}
