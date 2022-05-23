package lab2_FIT;

public class Task1 {
	public static String reverse(String s) {
		if (s.length() == 1)
			return s;
		else
			return s.charAt(s.length() - 1) + reverse(delete(s));
	}

	public static String delete(String s) {
		StringBuilder s1 = new StringBuilder();
		for (int i = 0; i < s.length() - 1; i++) {
			s1.append(s.charAt(i));
		}
		return String.valueOf(s1);
	}

	public static void main(String[] args) {
		String s = "nguyen minh chau";
		System.out.println(reverse(s));
	}
}
