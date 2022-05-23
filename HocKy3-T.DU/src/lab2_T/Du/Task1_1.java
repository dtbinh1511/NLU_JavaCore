package lab2_T.Du;

public class Task1_1 {
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n == 1)
			return 1;
		else
			return (int) (n * Math.pow(-1, n + 1)) + getSn1(n - 1);
	}

	// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
	public static int getSn2(int n) {
		if (n == 1)
			return 1;
		else
			return factorial(n) + getSn2(n - 1);
	}

	// bo tro getSn2
	public static int factorial(int n) {
		if (n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n == 1)
			return 1;
		else
			return n * n + getSn3(n - 1);
	}

	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>0
	public static double getSn4(int n) {
		if (n == 0)
			return 1;
		else
			return 1.0 / supportGetSn4(n) + getSn4(n - 1);
	}

	public static double supportGetSn4(int n) {
		if (n == 1)
			return 2;
		else
			return 2 * n * supportGetSn4(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(getSn1(5));
		System.out.println(getSn2(3));
		System.out.println(getSn3(3));
		System.out.println(getSn4(3));
	}
}
