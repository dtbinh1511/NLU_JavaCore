package lab2_FIT;

public class Task5 {
	private static int i = 2;

	public static boolean isPrime(int num) {
		if (num == i)
			return true;
		else if (num % 2 == 0)
			return false;
		else {
			i++;
			return isPrime(num);
		}
	}

	public static void main(String[] args) {
		System.out.println(isPrime(7));
	}
}
