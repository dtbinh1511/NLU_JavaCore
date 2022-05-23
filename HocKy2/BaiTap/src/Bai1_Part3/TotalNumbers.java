package Bai1_Part3;

import java.util.Scanner;

public class TotalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        int sum = 0;
        int x;
        while (n > 0) {
            x = n % 10;
            n /= 10;
            sum += x;
        }
        System.out.println("Result: " + sum);
        sc.close();
    }
}