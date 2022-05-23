
public interface Inventory {
	public String toString();

	public boolean equals(Object obj);

	public boolean contains(String toyName);

	public boolean isBelow(double threshold);

	public double howMany();

	public Inventory raisePrice();

	public void raisePriceMutuable();

	public double totalPrice();

	public double averagePrice();

	public void replaceName(String nameWantReplace, String newName);

	public Inventory eliminate(String nameToy);

	public Inventory sortByName();

	public Inventory inserByName(Toy that);

	public Toy maxPrice();
}
