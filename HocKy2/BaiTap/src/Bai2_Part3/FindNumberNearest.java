package Bai2_Part3;

import java.util.Scanner;

public class FindNumberNearest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element of array");
        int n = sc.nextInt();
        System.out.println("Enter a number");
        int x = sc.nextInt();
        System.out.println("Enter array");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int m = Math.abs(x - arr[i]);
            if (isPrime(arr[i]) && m < min) {
                min = m;
                index = i;
            }
        }
        System.out.printf("Number %d nearest is: %d", x, arr[index]);
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