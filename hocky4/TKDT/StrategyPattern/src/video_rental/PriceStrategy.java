package video_rental;

public interface PriceStrategy {
	public double getChargeRetal(int dateRent);
	public double getFrequentRenterPoint(int dateRent);
}
