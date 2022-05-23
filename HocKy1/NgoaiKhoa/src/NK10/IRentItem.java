package NK10;

public interface IRentItem {
	public String toString();

	public boolean equals(Object obj);

	public boolean isRentSomeItem(String thatTitle);

	public double fineTotal();
}
