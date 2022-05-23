package video_rental;

public class PriceNewRelease implements PriceStrategy {

	@Override
	public double getChargeRetal(int dateRent) {
		return dateRent * 4000;
	}

	@Override
	public double getFrequentRenterPoint(int dateRent) {
		return (dateRent > 1) ? 2 : 1;
	}

}
