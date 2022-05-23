package AddEx;

// ví dụ ước của 5 là 1 ,5
public class LietKeUoc {
	public static void lietKe(int number) {
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				System.out.print(i + " ");
			}
		}
	}
	public static void main(String[] args) {
		lietKe(10);
	}
}
