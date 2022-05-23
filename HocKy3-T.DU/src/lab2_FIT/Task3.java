package lab2_FIT;

public class Task3 {
	public static int binaryNumber(int n) {
		if (n == 0)
			return 0;
		else
			return (n % 2) + 10 * binaryNumber(n / 2);
	}

	public static void main(String[] args) {
		System.out.println(binaryNumber(123));
	}
}
