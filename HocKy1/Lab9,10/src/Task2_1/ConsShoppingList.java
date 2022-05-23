package Task2_1;

public class ConsShoppingList implements IShoppingList {
	protected AnItem first;
	protected IShoppingList rest;

	public ConsShoppingList(AnItem first, IShoppingList rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	public String toString() {
		return this.first.toString() + this.rest.toString();
	}

	public int howMany() {
		return this.first.howMany() + this.rest.howMany();
	}

	public String brandList() {
		return this.first.brandList() + this.rest.brandList();
	}

	@Override
	public double highestPrice() {
		if (this.first.getPrice() > this.rest.highestPrice())
			return this.first.price;
		return this.rest.highestPrice();
	}

}
