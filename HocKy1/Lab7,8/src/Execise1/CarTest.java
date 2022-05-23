package Execise1;

import junit.framework.TestCase;

public class CarTest extends TestCase {
	public void testCarConstructor() {
		AVihecle c1 = new Car(100, 10, 24);
	}

	public void testRefuelCost() {
		AVihecle c1 = new Car(100, 10, 24);
		assertEquals(c1.refuelCost(30), 3000.0);
	}

	public void testFuelConsumption() {
		AVihecle c1 = new Car(10000, 100, 24);
		assertEquals(c1.fuelConsumption(), -140.0, 0.001);
	}

	public void testHowFar() {
		AVihecle c1 = new Car(100, 10, 24);
		assertEquals(c1.howFar(), -1400.0, 0.001);
	}
}
