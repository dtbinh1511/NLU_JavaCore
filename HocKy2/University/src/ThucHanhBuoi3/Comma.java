package ThucHanhBuoi3;

//import java.text.NumberFormat;
//import java.util.Scanner;

public class Comma {
	public static void main(String[] args) {
		int number = 1132422323;
		System.out.println(addComma(number));
	}

	public static String addComma(int number) {
		int count = 0;
		String numStr = Integer.toString(number);
		String output = "";
		for (int i = numStr.length() - 1; i >= 0; i--) {
			output = numStr.charAt(i) + output;
			count++;
			if (count == 3 & i > 0) {
				output = "," + output;
				count = 0;
			}
		}
		return output;
	}
}
