package Bai1_Part2;

import java.util.Scanner;

public class Ex9SumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        int sum = 0;
        while (n > 0) {
            int x = n % 10;
            n /= 10;
            sum += x;
        }
        System.out.println("Result is: " + sum);
        sc.close();
    }
}