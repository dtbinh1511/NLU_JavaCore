
public class Bai_1_Recursion {
	// 1/4 + 1/9+...+1/(n+1)^2 n>=1
	public static double getSn(int n) {
		if (n == 1) // base case
			return 1.0 / 4.0;
		return 1.0 / ((n + 1) * (n + 1)) + getSn(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(getSn(2));
	}
}
