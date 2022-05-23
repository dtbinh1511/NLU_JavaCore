package Bai1_Part3;

import java.util.Scanner;

public class ListPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        int count = 0;
        int x = 2;
        while (true) {
            if (isPrime(x)) {
                count++;
                System.out.print(x + " ");
            }
            if (count == n) {
                break;
            }
            if (x == 2) {
                x++;
            } else {
                x += 2;
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