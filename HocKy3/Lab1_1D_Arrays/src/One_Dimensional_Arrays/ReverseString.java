package One_Dimensional_Arrays;

public class ReverseString {
	public static String reverse1(String input) {
		StringBuilder result = new StringBuilder();
		for (int i = input.length() - 1; i >= 0; i--) {
			result.append(input.charAt(i));
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String input = "abcd";
		System.out.println(reverse1(input));
	}
}
