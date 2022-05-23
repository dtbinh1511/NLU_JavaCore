package singleton;

public class ChocolateBoilerUsePattern {
	private static ChocolateBoilerUsePattern instance; // khai báo

	private boolean empty;
	private boolean boiled;

	private ChocolateBoilerUsePattern() {
		empty = true;
		boiled = false;
	}

	public static ChocolateBoilerUsePattern getInstance() {
		if (instance == null) {
			instance = new ChocolateBoilerUsePattern(); // khởi tạo
		}
		return instance;
	}

	public void fill() {
		if (isEmpty()) {// fill the boiler with a milk/chocolate mixture
			empty = false;
			boiled = false;
		}
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) // drain the boiled milk and chocolate
			empty = true;
	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) // bring the contents to a boil
			boiled = true;
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}
}
