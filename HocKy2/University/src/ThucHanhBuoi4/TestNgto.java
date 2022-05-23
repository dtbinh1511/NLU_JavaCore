package ThucHanhBuoi4;

public class TestNgto {
	public static boolean checkPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void primeFactor(int number) {
		for (int i = 2; i <= number; i++) {
			if (checkPrime(i) == true && number % i == 0) {
				number /= i;
				if (number == 1) {
					System.out.print(i);
				} else {
					System.out.print(i + " x ");
				}
				i = i - 1;
			}
		}
	}

	public static void main(String[] args) {
		primeFactor(56);
	}

}
