package Recursive;

public class UCLN {
	public static int ucln(int a, int b) {
		if (a % b == 0)
			return b;
		return ucln(b, a % b);
	}

	public static void main(String[] args) {
		System.out.println(ucln(15, 9));
	}
}
