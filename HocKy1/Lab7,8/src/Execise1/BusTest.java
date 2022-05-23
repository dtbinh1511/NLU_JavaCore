package Execise1;

import junit.framework.TestCase;

public class BusTest extends TestCase {
	public void testBusConstructor() {
		AVihecle b1 = new Bus(100, 10, 24);
	}

	public void testRefuelCost() {
		AVihecle b1 = new Bus(100, 10, 24);
		assertEquals(b1.refuelCost(20), 2000.0);
	}

	public void testFuelConsumption() {
		AVihecle b1 = new Bus(10000, 100, 24);
		assertEquals(b1.fuelConsumption(), 76.0);
	}

	public void testHowFar() {
		AVihecle b1 = new Bus(100, 10, 24);
		assertEquals(b1.howFar(), 760.0);
	}
}
