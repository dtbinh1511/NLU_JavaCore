package String;

import java.util.Scanner;

public class DaoNguocChuoi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = sc.nextLine();
		System.out.println("Length: " + s.length());
		// tách chữ khoảng trắng
		String[] s1 = s.split("\\s");
		for (String s2 : s1) {
			System.out.println(s2);
		}

		StringBuilder input1 = new StringBuilder();
		input1.append(s);// nối chuỗi s
		input1 = input1.reverse(); // đảo ngược
		System.out.println(input1);
		// for (int i = 0; i < input1.length(); i++)
		// System.out.print(input1.charAt(i));

		sc.close();
	}
}