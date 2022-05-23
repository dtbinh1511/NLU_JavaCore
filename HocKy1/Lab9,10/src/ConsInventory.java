
public class ConsInventory implements Inventory {
	protected Toy first;
	protected Inventory rest;

	public ConsInventory(Toy first, Inventory rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	public String toString() {
		return this.first.toString() + this.rest.toString();
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ConsInventory))
			return false;
		else {
			ConsInventory other = (ConsInventory) obj;
			return this.first.equals(other.first) && this.rest.equals(other.rest);
		}
	}

	public boolean contains(String toyName) {
		return this.first.isName(toyName) || this.rest.contains(toyName);
	}

	@Override
	public boolean isBelow(double threshold) {
		if (this.first.isBelowPrice(threshold) && this.rest.isBelow(threshold))
			return true;
		return false;
	}

	@Override
	public double howMany() {
		return this.first.available + this.rest.howMany();
	}

	@Override
	public Inventory raisePrice() {
		return new ConsInventory(this.first.copyWithRaisePrice(), this.rest.raisePrice());
	}

	@Override
	public void raisePriceMutuable() {
		this.first.getNewPrice();
		this.rest.raisePriceMutuable();
	}

	public double totalPrice() {
		return this.first.price + this.rest.totalPrice();
	}

	public double averagePrice() {
		return this.totalPrice() / this.howMany();
	}

	@Override
	public Inventory eliminate(String nameToy) {
		if (this.first.getName().equals(nameToy))
			return this.rest.eliminate(nameToy);
		return new ConsInventory(this.first, this.rest.eliminate(nameToy));

	}

	@Override
	public void replaceName(String nameWantReplace, String newName) {
		if (this.first.getName().equals(nameWantReplace))
			this.first.replaceName(newName);
		this.rest.replaceName(nameWantReplace, newName);
	}

	@Override
	public Inventory sortByName() {
		return this.rest.sortByName().inserByName(first);
	}

	@Override
	public Inventory inserByName(Toy that) {
		if (this.first.compareTo(that) < 0)
			return new ConsInventory(first, this.rest.inserByName(that));
		else
			return new ConsInventory(that, this);

//			return new ConsInventory(that, new ConsInventory(this.first, this.rest));

	}

	public Toy maxPrice() {
		if (this.rest.maxPrice() == null)
			return this.first;
		if (this.first.hasLowerPrice(rest.maxPrice()))
			return this.rest.maxPrice();
		return this.first;

	}
	// trung ten so sanh toi gia
}


