package video_rental;

public class PriceChildren implements PriceStrategy {

	@Override
	public double getChargeRetal(int dateRent) {
		double price = (dateRent < 4) ? 2500 : (dateRent - 4) * 1500 + 2500;
		return price;
	}

	@Override
	public double getFrequentRenterPoint(int dateRent) {
		return 1;
	}

}
