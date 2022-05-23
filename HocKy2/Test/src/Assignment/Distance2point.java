package Assignment;

import java.util.Scanner;

public class Distance2point {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter point A");
        int xA = sc.nextInt();
        int yA = sc.nextInt();
        System.out.println("Enter point B");
        int xB = sc.nextInt();
        int yB = sc.nextInt();

        double d = Math.sqrt((xA - xB) * (xA - xB) + (yA - yB) * (yA - yB));
        System.out.println("Distance between A and B is: " + d);
        sc.close();

    }
}