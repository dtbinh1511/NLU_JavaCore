package Bai2_Part2;

import java.util.Scanner;

public class Ex3FindElementNearest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers in array");
        int n = sc.nextInt();
        System.out.println("Enter a number");
        int x = sc.nextInt();
        System.out.println("Enter a array");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int m = Math.abs(x - array[i]);
            if (isPrime(array[i]) == true && m < min) {
                min = m;
                index = i;
            }
        }
        System.out.printf("Element nearest %d is: %d ", x, array[index]);
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