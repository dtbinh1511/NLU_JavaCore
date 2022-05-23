package singleton_pattern;

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	private volatile static ChocolateBoiler uniqueInstance;

	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}

	public static ChocolateBoiler getInstance() {
		if (uniqueInstance == null) {
			synchronized (ChocolateBoiler.class) {
				if(uniqueInstance == null)
				uniqueInstance = new ChocolateBoiler();
			}
		}
		return uniqueInstance;
	}

	public void fill() {
		if (isEmpty()) {
			System.out.println("fill the boiler with a milk/chocolate mixture");
			empty = false;
			boiled = false;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			System.out.println("bring the contents to a boil");
			boiled = true;
		}
	}
	
	public void drain() {
		if(!isEmpty() && isBoiled()) {
			System.out.println("drain the boiled milk and chocolate ");
			empty = true;
		}
	}
}
