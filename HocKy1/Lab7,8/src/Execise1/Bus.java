package Execise1;

public class Bus extends AVihecle {
	int nPassengers;

	public Bus(double fuelTankVolume, double averageMilePerGallon, int nPassengers) {
		super(fuelTankVolume, averageMilePerGallon);
		this.nPassengers = nPassengers;
	
	}

// fuel consumption on passengers
	@Override
	public double fuelConsumption() {
		return this.averageMilePerGallon * (1 - 0.01 * this.nPassengers);
	}

// how far ??
	@Override
	public double howFar() {
		return this.fuelTankVolume * this.fuelConsumption();
	}

}
