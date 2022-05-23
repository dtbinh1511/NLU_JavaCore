package singleton;

public class Test {
	public static void main(String[] args) {			
		ChocolateBoiler.fill();
		ChocolateBoiler.boil();
		ChocolateBoiler.fill();
	}
}
