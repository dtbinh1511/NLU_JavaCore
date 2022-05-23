package electric_management;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		EVNComDivision evnComDivision = new EVNComDivision("Electric VietNam");

		ResidentalCustomer r1 = new ResidentalCustomer("Nguyen Thi Teo", "01234");
		BussinessCustomer b1 = new BussinessCustomer("Binh Thanh Nguyen", "00001", 10231223);

		evnComDivision.register(b1);
		evnComDivision.register(r1);

		r1.addReading(new OneReading(4551, new GregorianCalendar(2001, Calendar.JANUARY, 15).getTime()));
		r1.addReading(new OneReading(4796, new GregorianCalendar(2001, Calendar.FEBRUARY, 15).getTime()));
		b1.addReading(new ThreeReading(20560, new GregorianCalendar(2001, Calendar.JANUARY, 10).getTime(), 5000, 2000));
		b1.addReading(
				new ThreeReading(21796, new GregorianCalendar(2001, Calendar.FEBRUARY, 10).getTime(), 5236, 2150));

		System.out.println(evnComDivision.showByID("00001"));
//		System.out.println(evnComDivision.allInvoice());
		
	}
}
