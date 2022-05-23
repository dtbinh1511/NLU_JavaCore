package NK7;

import junit.framework.TestCase;

public class ListTest extends TestCase {
	public void testConstructor() {
		Product p1 = new ImportedProduct("19130017A", 120000, "Kem duong da", new Date(15, 11, 2001), "China");
		Product p2 = new DomesticProduct("19130016A", 95000, "My tom hao hao", new Date(15, 11, 2001));
		Product p3 = new ImportedProduct("19130015A", 140000, "Kem tron trang da", new Date(15, 11, 2001), "China");

		OrderItem oi1 = new OrderItem(p3, 5);
		OrderItem oi2 = new OrderItem(p2, 1);
		OrderItem oi3 = new OrderItem(p1, 3);

		IList empty = new MTList();
		IList i1 = new ConsList(oi1, empty);
		IList i2 = new ConsList(oi2, i1);
		IList i3 = new ConsList(oi3, i2);

		Order o1 = new Order("Nguyen Van A", new Date(15, 11, 2001), i3);

		System.out.println(o1);
		 
	}
}