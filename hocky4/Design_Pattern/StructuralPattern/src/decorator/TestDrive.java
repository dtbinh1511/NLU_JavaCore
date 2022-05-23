package decorator;

public class TestDrive {
	public static void main(String[] args) {
		Beverage houseBlend = new HouseBlend();
		Milk milk1 = new Milk(houseBlend);
		Milk milk2 = new Milk(milk1);
		Mocha mocha = new Mocha(milk2);
		
		System.out.println(mocha.getDescription());
		System.out.println(mocha.cost());
	}
}
