package Bai1_Part3;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        long f0 = 0, f1 = 1, fn;
        for (int i = 0; i <= n; i++) {
            if (i < 2) {
                System.out.println(i);
            } else {
                fn = f0 + f1;
                f0 = f1;
                f1 = fn;
                System.out.println(fn);
            }

        }
        sc.close();
    }
}