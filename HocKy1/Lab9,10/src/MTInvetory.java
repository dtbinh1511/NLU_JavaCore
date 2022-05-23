
public class MTInvetory implements Inventory {
	public String toString() {
		return "";
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MTInvetory))
			return false;
		return true;
	}

	public boolean contains(String toyName) {
		return false;
	}

	@Override
	public boolean isBelow(double threshold) {
		return true;
	}

	@Override
	public double howMany() {
		return 0;
	}

	@Override
	public Inventory raisePrice() {
		return new MTInvetory();
	}

	@Override
	public void raisePriceMutuable() {
	}

	public double averagePrice() {
		return 0;
	}

	public double totalPrice() {
		return 0;
	}

	@Override
	public void replaceName(String nameWantReplace, String newName) {

	}

	public Inventory eliminate(String nameToy) {
		return new MTInvetory();
	}

	@Override
	public Inventory sortByName() {
		return new MTInvetory();
	}

	@Override
	public Inventory inserByName(Toy that) {
		return new ConsInventory(that, this);
//		return new ConsInventory(that, new MTInvetory());
	}

	@Override
	public Toy maxPrice() {
		return null;
	}

}
