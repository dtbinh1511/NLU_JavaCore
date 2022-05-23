package Execise1;

import junit.framework.TestCase;

public class TruckTest extends TestCase {
	public void testBusConstructor() {
		AVihecle t1 = new Truck(100, 10, 24);
	}

	public void testRefuelCost() {
		AVihecle t1 = new Truck(100, 10, 24);
		assertEquals(t1.refuelCost(20), 2000.0);
	}

	public void testFuelConsumption() {
		AVihecle t1 = new Truck(10000, 100, 24);
		assertEquals(t1.fuelConsumption(), -20.0, 0.001);
	}

	public void testHowFar() {
		AVihecle t1 = new Truck(100, 10, 24);
		assertEquals(t1.howFar(), -200.0, 0.001);
	}
}
