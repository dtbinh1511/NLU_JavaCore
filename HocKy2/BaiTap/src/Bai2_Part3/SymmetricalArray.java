package Bai2_Part3;

import java.util.Arrays;
import java.util.Scanner;

public class SymmetricalArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element of array");
        int n = sc.nextInt();
        System.out.println("Enter array");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] a1 = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        int[] a2 = Arrays.copyOf(arr, arr.length);
        if (Arrays.equals(a1, a2)) {
            System.out.println("Symmetrical Array");
        } else {
            System.out.println("Not Symmetrical Array");
        }
        sc.close();
    }
}