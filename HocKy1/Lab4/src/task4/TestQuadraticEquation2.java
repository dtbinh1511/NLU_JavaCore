package task4;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

public class TestQuadraticEquation2 extends TestCase {
public void testQuadraticEquation2 () {
	QuadraticEquation2 q1 = new QuadraticEquation2 (2, 3, 3);
}
public void testWhatkind () {
	QuadraticEquation2 q1 = new QuadraticEquation2 (2, 3, 3);
	assertEquals(q1.whatKind(), "none");
}


}
