package lab2_FIT;

public class Task2 {
	public static int sumOdd(int n) {
		if (n == 0)
			return 1;
		else
			return (2 * n + 1) + sumOdd(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(sumOdd(2));
	}
}
