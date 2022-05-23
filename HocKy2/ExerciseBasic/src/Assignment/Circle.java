package Assignment;

import java.util.Scanner;

public class Circle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius");
		double r = sc.nextDouble();

		double p = Math.PI * 2 * r;
		double s = Math.PI * r * r;

		System.out.println("Area of circle is: " + s);
		System.out.println("Perimeter of circle is: " + p);
		sc.close();
	}

}
