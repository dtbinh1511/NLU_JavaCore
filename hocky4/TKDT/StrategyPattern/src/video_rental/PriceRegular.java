package video_rental;

public class PriceRegular implements PriceStrategy {

	@Override
	public double getChargeRetal(int dateRent) {
		double price = (dateRent < 3) ? 3000 : (dateRent - 2) * 1000 + 3000;
		return price;
	}

	@Override
	public double getFrequentRenterPoint(int dateRent) {
		return 1;
	}

}
