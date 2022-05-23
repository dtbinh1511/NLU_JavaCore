package AddEx;

public class TongChanLe {
	public static boolean check(int number) {
		if (number % 2 == 0) {
			return true;
		}
		return false;
	}

	public static int total(int number) {
		int x;
		int sum = 0;
		if (check(number) == true) {
			x = 2;
		} else {
			x = 1;
		}
		for (int i = x; i <= number; i += 2) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		int number = 5;
		System.out.println(total(number));
	}
}
