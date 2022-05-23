package Bai1;
import java.util.Scanner;

public class Ex1VeHCNBangSao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length and width of rectangle ");
		int length = sc.nextInt();
		int width = sc.nextInt();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(" * ");
			}
			System.out.println();
		}
		sc.close();

	}

}
