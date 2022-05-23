package Bai1_Part2;

import java.util.Scanner;

public class Ex11ListPrimeNumbersFirst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number prime output");
        int n = sc.nextInt();
        int x = 2;
        int count = 0;
        while (true) {
            if (isPrime(x)) {
                System.out.print(x + "  ");
                count++;
                if (count == n) {
                    break;
                }
            }
            if (x == 2) {
                x++;
            } else {
                x += 2;
            }
        }
        sc.close();
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}