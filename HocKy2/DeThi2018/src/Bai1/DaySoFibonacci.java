package Bai1;

public class DaySoFibonacci {
	public static boolean checkIsPrime(int number) {
		if (number < 2)
			return false;
		else {
			for (int i = 2; i <= Math.sqrt(number); i++) {
				if (number % i == 0)
					return false;
			}
		}
		return true;
	}

	public static void fibonacci(int number) {
		int f0 = 0, f1 = 1, fn = f0 + f1;
		while (fn < number) {
			System.out.println(fn);
			f0 = f1;
			f1 = fn;
			fn = f0 + f1;
		}
	}
	public static void main(String[] args) {
		fibonacci(100);
	}
}
