package AddEx;

public class PhanTichThuaSoNgTo {

	public static boolean ktraNgto(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void phanTich(int number) {
		for (int i = 2; i <= number; i++) {
			if (ktraNgto(i) == true && number % i == 0) {
				number /= i;
				if (number != 1) {
					System.out.print(i + " x ");
				} else {
					System.out.print(i);
				}
				i = i - 1;
			}
		}
	}

	public static void main(String[] args) {
		int number = 10;
		phanTich(number);
	}
}
