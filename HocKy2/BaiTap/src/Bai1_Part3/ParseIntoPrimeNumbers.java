package Bai1_Part3;

import java.util.Scanner;

public class ParseIntoPrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
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
        for (int i = 2; i < Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}