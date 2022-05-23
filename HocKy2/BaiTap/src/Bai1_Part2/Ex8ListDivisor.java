package Bai1_Part2;

import java.util.Scanner;

public class Ex8ListDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        int count = 0;
        System.out.print("Divisors of " + n + " : ");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("\nThere are " + count + " divisors.");
        sc.close();

    }

}