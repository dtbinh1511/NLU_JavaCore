package NK5;

public class Cabinet extends Product {
	private boolean mirror;

	public Cabinet(Size size, String kindWood, int unitPrice, boolean mirror) {
		super(size, kindWood, unitPrice);
		this.mirror = mirror;
	}
	public String toString () {
		return "\n" + "CABINET " + "\n" + "Size: " + this.size+ "\n"
				+ "Kind Wood: " + this.kindWood + "\n"
				+ "Price: " + this.unitPrice +" dollar" +"\n"
				+"Have Mirror ?  " + true 
				+"\n";
}
}