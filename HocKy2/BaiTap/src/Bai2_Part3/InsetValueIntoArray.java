package Bai2_Part3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * InsetValueIntoArray
 */
public class InsetValueIntoArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element of array");
        int n = sc.nextInt();
        System.out.println("Enter value add array");
        int x = sc.nextInt();
        System.out.println("Enter array");
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int index = -1;
        for (int i = 0; i <= n; i++) {
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
        Arrays.sort(arr);
        System.out.println("Array after insert value:" + Arrays.toString(arr));
        sc.close();
    }

}