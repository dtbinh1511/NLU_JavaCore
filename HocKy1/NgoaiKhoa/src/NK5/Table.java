package NK5;

public class Table extends Product{
	private boolean drawer;

	public Table(Size size, String kindWood, int unitPrice, boolean drawer) {
		super(size, kindWood, unitPrice);
		this.drawer = drawer;
	}

	public String toString () {
		return "\n" + "TABLE " + "\n" + "Size: " + this.size+ "\n"
				+ "Kind Wood: " + this.kindWood + "\n"
				+ "Price: " + this.unitPrice +" dollar" + "\n"
				+"Have Drawer ?  " + false ;

}
}