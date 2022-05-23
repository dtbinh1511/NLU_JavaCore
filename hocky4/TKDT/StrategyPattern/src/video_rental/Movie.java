package video_rental;

public class Movie {
	private String title;
	private PriceStrategy priceStrategy;

	public Movie(String title, PriceStrategy priceStrategy) {
		super();
		this.title = title;
		this.priceStrategy = priceStrategy;
	}

	public String getTitle() {
		return title;
	}

	public double getChargeRental(int dateRent) {
		return priceStrategy.getChargeRetal(dateRent);
	}

	public double getFrequentRenterPoint(int dateRent) {
		return priceStrategy.getFrequentRenterPoint(dateRent);
	}
}
