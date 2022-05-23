package Bai1_Part3;

import java.util.Scanner;

public class SumParity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        int x;
        if (n % 2 == 0) {
            x = 2;
        } else {
            x = 1;
        }
        int sum = 0;
        for (int i = x; i <= n; i += 2) {
            sum += i;
        }
        System.out.println("Result: " + sum);
        sc.close();
    }
}