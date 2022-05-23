package Assignment;

import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter second");
        int second = sc.nextInt();

        int h = second / 3600;
        second = second % 3600;
        int m = second / 60;
        second = second % 60;
        

        System.out.printf("Time:%2d:%2d:%2d", h, m, second);
        sc.close();
    }
}