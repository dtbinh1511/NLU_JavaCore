package lab2_FIT;

public class Task7 {
	public static int revesive(int n) {
		if (n ==0)
			return 0;
		else {
			return n % 10 * exponential(n) + revesive(n / 10);
		}
	}

	public static int exponential(int n) {
		if (n < 10)
			return 1;
		else
			return 10 * exponential(n / 10);
	}

	public static void main(String[] args) {
		System.out.println(revesive(1980));
	}
}
