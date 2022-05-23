package video_rental;

import java.util.Date;

public class RentItem {
	private Movie movie;
	private Date retalStartDate;

	public RentItem(Movie movie, Date retalStartDate) {
		super();
		this.movie = movie;
		this.retalStartDate = retalStartDate;
	}

	public int getNumOfRentalDays() {
		Date now = new Date();

		long duration = now.getTime() - retalStartDate.getTime();
		long rentDays = duration / (24 * 3600000);

		return (int) rentDays;
	}

	public Movie getMovie() {
		return movie;
	}

	public Date getRetalStartDate() {
		return retalStartDate;
	}

	public double getChargeRent() {
		return movie.getChargeRental(getNumOfRentalDays());
	}

	public double getFrequentRenterPoint() {
		return movie.getFrequentRenterPoint(getNumOfRentalDays());
	}
}
