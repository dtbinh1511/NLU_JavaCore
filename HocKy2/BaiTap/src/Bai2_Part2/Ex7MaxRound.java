package Bai2_Part2;

import java.util.Scanner;

/**
 * Ex7MaxRound
 */
public class Ex7MaxRound {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element of array");
        int n = sc.nextInt();
        System.out.println("Enter array");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 1;
        int max = 0;
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                count++;
            }
            if (arr[i + 1] <= arr[i]) {
                index = count;
                count = 1;
            }
            if (i == n - 2) {
                index = count;
            }
            if (index > max) {
                max = index;
            }

        }
        System.out.println("Max Round: " + max);
        sc.close();
    }
}