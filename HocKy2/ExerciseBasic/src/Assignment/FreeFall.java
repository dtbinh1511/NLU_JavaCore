package Assignment;

import java.util.Scanner;

/**
 * FreeFall
 */
public class FreeFall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height");
        int h = sc.nextInt();
        int g = 20; // m/s^2
        double t = Math.sqrt((2 * h) / g);
        double v = g * t;
        System.out.println("Time fall: " + t + "s");
        System.out.println("Speed fall: " + v + "m/s");
        sc.close();
    }
}