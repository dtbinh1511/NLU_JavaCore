package AddEx;

public class SoChinhPhuong {
	public static boolean checkSoChinhPhuong(int number) {
		int result = (int) Math.sqrt(number);
		if (result * result == number) {
			return true;
		}
		return false;
	}

	public static void firstNumbers(int firstNumber) {
		int count = 0;
		int number = 0;
		while (true) {
			if (checkSoChinhPhuong(number) == true) {
				System.out.print(number + " ");
				count++;
			}
			number++;
			if (count == firstNumber)
				break;
		}
		System.out.println();
	}

	public static void limitInApprox(int number1, int number2) {
		for (int i = number1; i <= number2; i++) {
			if (checkSoChinhPhuong(i) == true) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(checkSoChinhPhuong(9));
		System.out.println("==============================");
		firstNumbers(10);
		System.out.println("==============================");
		limitInApprox(0, 100);
	}
}
