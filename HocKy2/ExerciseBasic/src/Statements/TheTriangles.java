package Statements;

import java.util.Scanner;

public class TheTriangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a,b,c");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a + b > c || a + c > b || b + c > a) {
            if (a == b && a == c && b == c) {
                System.out.println("This is equilateral triangle.");
            }
            if (a == b || a == c || b == c) {
                System.out.println("This is isosceles triangle.");
            }
            if (a * a + b * b == c * c || a * a + c * c == b * b || c * c + b * b == a * a) {
                System.out.println("This is right-angle triangle.");
            }
            if ((a * a + b * b == c * c || a * a + c * c == b * b || c * c + b * b == a * a)
                    && (a == b || a == c || b == c)) {
                System.out.println("This is right-angle-isosceles triangle. ");

            } 

        } else {
            System.out.println("This isn't triangle.");
        }
    }

}
