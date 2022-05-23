package singleton;

public class ChocolateBoiler {
	private static boolean empty;
	private static boolean boiled;

	public ChocolateBoiler() {
		empty = true;
		boiled = false;
	}

	public static void fill() {
		if (isEmpty()) {// fill the boiler with a milk/chocolate mixture
			empty = false;
			boiled = false;
		}
	}
	public static void drain() {
		if (!isEmpty() && isBoiled()) // drain the boiled milk and chocolate
			empty = true;
	}

	public static void boil() {
		if (!isEmpty() && !isBoiled()) // bring the contents to a boil			
			boiled = true;		
	}

	public static boolean isEmpty() {
		return empty;
	}

	public static boolean isBoiled() {
		return boiled;
	}

}
