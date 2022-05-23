package lab2_FIT;

public class Task4 {
	public static String changle(int s) {
		if (s < 60)
			return s + "";
		else {
			int h = s / 3600;
			s %= 3600;
			int m = s / 60;
			s %= 60;
			return h + ":" + m + ":" + s;
		}
	}

	public static void main(String[] args) {
		System.out.println(changle(3665));
	}
}
