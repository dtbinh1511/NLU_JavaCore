package ThayToan;

public class Cau1 {
	public static String divideBy3(int number) {
		String s = "";
		int a;
		while (number > 0) {
			a = number % 10;
			if (a % 3 == 0) {
				s = a + s;
			}
			number /= 10;
		}

		return s;
	}

	public static void main(String[] args) {
		System.out.println(divideBy3(444301));
	}
}
