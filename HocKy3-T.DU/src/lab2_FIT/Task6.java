package lab2_FIT;

public class Task6 {
	public static int sum(int n) {
		if (n < 10)
			return n;
		else
			return n % 10 + sum(n / 10);
	}
	
	public static void main(String[] args) {
		System.out.println(sum(123));
	}
}
