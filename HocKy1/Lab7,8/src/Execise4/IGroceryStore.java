package Execise4;

public interface IGroceryStore {
	public double unitPrice();

	public boolean lowerPrice(double amount);

	public boolean cheaperThan(IGroceryStore other);
}
