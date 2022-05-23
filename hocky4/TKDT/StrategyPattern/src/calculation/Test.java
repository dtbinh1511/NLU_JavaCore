package calculation;

public class Test {
	public static void main(String[] args) {
		Strategy strategy = new Addition();
		System.out.println(strategy.calculate(3, 4));

		strategy = new Subtraction();
		System.out.println(strategy.calculate(3, 4));

		strategy = new Multiplication();
		System.out.println(strategy.calculate(3, 4));
	}
}
