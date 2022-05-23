package NK5;

public class Chair extends Product {

	public Chair(Size size, String kindWood, int unitPrice) {
		super(size, kindWood, unitPrice);

	}
public String toString () {
	return "\n" + "CHAIR " + "\n" + "Size: " + this.size+ "\n"
			+ "Kind Wood: " + this.kindWood + "\n"
			+ "Price: " + this.unitPrice +" dollar"
			+ "\n";
}

}
