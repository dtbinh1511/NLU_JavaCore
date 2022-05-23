package iterator;

public class Test {
	public static void main(String[] args) {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinnerMenu dinerMenu = new DinnerMenu();
		CaffeeMenu caffeeMenu = new CaffeeMenu();
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, caffeeMenu);
		waitress.printMenu();
	}
}
