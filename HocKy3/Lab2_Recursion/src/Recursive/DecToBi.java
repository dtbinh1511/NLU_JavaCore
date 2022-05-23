package Recursive;

public class DecToBi {

	public static void main(String[] args) {
		System.out.println(decToBi(33));
	}

	public static String decToBi(int n) {
		if (n == 1)
			return n / 2 + n % 2 + "";
		return decToBi(n / 2) + n % 2 + "";
	}
}
