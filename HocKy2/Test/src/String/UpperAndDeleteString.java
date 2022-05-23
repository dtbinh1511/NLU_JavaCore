package String;

import java.util.Scanner;

public class UpperAndDeleteString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string: ");
		String s = sc.nextLine();
		// String s1 = sc.nextLine();
		System.out.println(s.toUpperCase());
		System.out.println(s.substring(0, 1).toUpperCase() + s.substring(1));
		System.out.println(s.trim()); // xóa khoảng trắng trước sau	
//		System.out.println(s.replace("\\s", " "));
		sc.close();
	}
}