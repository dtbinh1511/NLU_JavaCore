package travel_management;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		TravelAgency travelAgency = new TravelAgency("Travel Goble");

		Trip t1 = new Trip(new Date(2021, 7, 1));
//		Trip t2 = new Trip(new Date(2021, 7, 1));
		Trip t3 = new Trip(new Date(2021, 7, 2));
//		Trip t4 = new Trip(new Date(2021, 7, 2));

		Tour d1 = new DomesticTour("Ha Noi 36 pho phuong", "....", 3, 1000);
		Tour d2 = new DomesticTour("Sapa", "....", 3, 900);
		Tour d3 = new DomesticTour("Hoi An", "....", 3, 850);

		Tour f1 = new ForeignTour("EU", "..", 10, 8000, "EU", 100);
		Tour f2 = new ForeignTour("US", "..", 5, 4000, "EU", 100);
		Tour f3 = new ForeignTour("Korea", "..", 10, 2000, "Korea", 50);

		Customer c1 = new Customer("A", "0121", "Hoa Mai", "a@mail.com", 2, "CHUYEN KHOAN");
		Customer c2 = new Customer("B", "0122", "Hoa Mai", "b@mail.com", 2, "CHUYEN KHOAN");
		Customer c3 = new Customer("C", "0123", "Hoa Mai", "c@mail.com", 2, "CHUYEN KHOAN");
		Customer c4 = new Customer("D", "0124", "Hoa Mai", "d@mail.com", 2, "CHUYEN KHOAN");

		c1.register(d2, t1);
		c2.register(f1, t1);
		c3.register(f3, t1);
		c4.register(d3, t1);

		d1.addTrip(t1);
		d1.addTrip(t3);
		d2.addTrip(t1);
		d2.addTrip(t3);
		d3.addTrip(t1);
		d3.addTrip(t3);

		f1.addTrip(t1);
		f1.addTrip(t3);
		f2.addTrip(t1);
		f2.addTrip(t3);
		f3.addTrip(t1);
		f3.addTrip(t3);

		// add customer
		f1.add(c2);
		f3.add(c3);
		d2.add(c1);
		d3.add(c4);

		travelAgency.add(f1, c2);
		travelAgency.add(f3, c3);
		travelAgency.add(d2, c1);
		travelAgency.add(d3, c4);

//		travelAgency.add(d1);
//		travelAgency.add(d2);
//		travelAgency.add(d3);
//		travelAgency.add(f1);
//		travelAgency.add(f2);
//		travelAgency.add(f3);
		
		System.out.println(travelAgency.showListTour());
		System.out.println(travelAgency.showCustomer());
	}
}
