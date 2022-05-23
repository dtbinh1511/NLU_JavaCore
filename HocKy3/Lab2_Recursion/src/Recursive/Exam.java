package Recursive;

public class Exam {
	public static int getSn1(int n) {
		if (n == 1)
			return 3;
		else
			return 3 * (n) + getSn1(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(getSn1(9));
	}
}
