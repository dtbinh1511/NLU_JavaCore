package Bai2_Part2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex6InsertANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element of array");
        int n = sc.nextInt();
        System.out.println("Enter array");
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter a number insert");
        int x = sc.nextInt();

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            arr[n] = x;
        } else {
            for (int i = n; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = x;
        }
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}