package iterator;

public class Waitress {
	PancakeHouseMenu pancakeHouseMenu;
	DinnerMenu dinnerMenu;
	CaffeeMenu caffeeMenu;

	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinnerMenu dinnerMenu, CaffeeMenu caffeeMenu) {
		super();
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinnerMenu = dinnerMenu;
		this.caffeeMenu = caffeeMenu;
	}

	public void printMenu() {

		Iterator dinnerIterator = dinnerMenu.createIterator();
		Iterator panIterator = pancakeHouseMenu.createIterator();
		Iterator caIterator = caffeeMenu.createIterator();

		System.out.println("\nBreafast");
		printMenu(panIterator);
		System.out.println("\nLunch");
		printMenu(dinnerIterator);
		System.out.println("\nCaffee");
		printMenu(caIterator);
	}

	private void printMenu(Iterator dinnerIterator) {
		while (dinnerIterator.hasNext()) {
			MenuItem menuItem = (MenuItem) dinnerIterator.next();
			System.out.println(menuItem.toString());
		}
	}
}
