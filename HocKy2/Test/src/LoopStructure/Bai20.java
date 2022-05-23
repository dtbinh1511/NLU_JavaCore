package LoopStructure;

import java.util.Scanner;

public class Bai20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int max = 0;
        System.out.println("list prime nhỏ hơn n");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i) == true) {
                int x = i;
                System.out.print(x + " ");
            }
        }
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                int u = i;
                if (u % 2 != 0) {
                    int x = u;
                    if (x > max) {
                        max = x;
                    }
                }
            }
        }
        System.out.println("\nƯớc lẻ lớn nhất là: " + max);
        System.out.println("is prime? " + isPrime(n));
        System.out.print(n + " = ");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i) == true && n % i == 0) {
                n /= i;
                if (n == 1) {
                    System.out.print(i);
                } else {
                    System.out.print(i + " x ");
                }
                i = i - 1;
            }
        }
        sc.close();
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}