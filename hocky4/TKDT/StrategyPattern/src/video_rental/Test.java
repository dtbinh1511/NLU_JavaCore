package video_rental;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {
	public static void main(String[] args) {
		Movie movies[] = { new Movie("Harry Potter", new PriceChildren()),
				new Movie("Pretty Woman", new PriceRegular()), new Movie("Gai nhay", new PriceNewRelease()),
				new Movie("Nguoi Ha Noi", new PriceRegular()), new Movie("Lo lem he pho", new PriceNewRelease()) };
		Customer teo = new Customer("Teo");
		Customer ti = new Customer("Ti");
		teo.rentMovie(movies[0], new GregorianCalendar(2021, Calendar.MAY, 22).getTime());
		teo.rentMovie(movies[2], new GregorianCalendar(2021, Calendar.MAY, 23).getTime());
		ti.rentMovie(movies[1], new GregorianCalendar(2021, Calendar.MAY, 21).getTime());
		ti.rentMovie(movies[3], new GregorianCalendar(2021, Calendar.MAY, 22).getTime());
		ti.rentMovie(movies[4], new GregorianCalendar(2021, Calendar.MAY, 24).getTime());

		System.out.println(teo.statement());
		System.out.println("-----------------");
		System.out.println(ti.statement());
		System.out.println("-----------------");
		teo.removeMovie("Gai nhay");
		System.out.println(teo.statement());
	}
}
