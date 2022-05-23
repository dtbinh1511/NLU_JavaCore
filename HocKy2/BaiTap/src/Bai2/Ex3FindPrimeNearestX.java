package Bai2;

import java.util.Scanner;

/**
 * Ex3FindPrimeNearestX
 */
public class Ex3FindPrimeNearestX {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n, x");
        int n = sc.nextInt();
        int x = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int index = 0;
        System.out.println("Enter array");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Check and find result
        for (int i = 0; i < n; i++) {
            int m = Math.abs(x - arr[i]);
            if (isPrime(arr[i]) == true && m < min) {
                min = m;
                index = i;

            }

        }
        System.out.println("Numbers nearest with x is: " + arr[index]);
        sc.close();
    }

    public static boolean isPrime(int n) {
        int a = (int) Math.sqrt(n);
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= a; i++) {
            if (n % i == 0) {
                return false;
            }

        }
        return true;
    }
}