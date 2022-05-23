package NK1;

import junit.framework.TestCase;

public class quadraticEquantionTest extends TestCase {
	public void testQuadraticEquantionConstructor() {
		quadraticEquantion q1 = new quadraticEquantion(0, 0, 5);
	}

	public void testWhatKind() {
		quadraticEquantion q1 = new quadraticEquantion(1, -2, 1);
		assertEquals(q1.whatKind(), "one");
	}
}
