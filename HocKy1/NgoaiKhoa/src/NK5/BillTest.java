package NK5;

import junit.framework.TestCase;

public class BillTest extends TestCase {
public void testConstructor() {
	Table t1 = new Table(new Size(2,3,2),"Pine", 20, true);
	Chair c1 = new Chair(new Size(3,2,1), "Oval wood", 19);
	Cabinet Ca1 = new Cabinet(new Size(2,3,5),"Pine",12, false);
	
	IList empty = new MTList();
	IList i1 = new ConsList(t1, empty);
	IList i2 = new ConsList(c1, i1);
	IList i3 = new ConsList(Ca1, i2);
	 
	Bill b1 = new Bill(new Date(15, 11, 2001), new Infomation("Do Thanh Binh", "Thu Duc, HCM"), new Infomation("Nguyen Hoai Bao", "KTX B"),i3);
	System.out.println(b1);
}
	
}
