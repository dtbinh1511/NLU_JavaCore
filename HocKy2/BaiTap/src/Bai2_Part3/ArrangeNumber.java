package Bai2_Part3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrangeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element of array");
        int n = sc.nextInt();
        int count = 0;
        int[] arr = new int[n];
        Random random = new Random();
        while (count < n) {
            arr[count++] = random.nextInt(100);
        }
        Arrays.sort(arr);
        System.out.println("Array arr: " + Arrays.toString(arr));

        int[] brr = new int[n];
        int size = 0;
        boolean isExist = false;

        for (int i = 0; i < n; i++) {
            isExist = false;
            for (int j = 0; j < size; j++) {
                if (arr[i] == brr[j]) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                brr[size++] = arr[i];
            }
        }
        brr = Arrays.copyOfRange(brr, 0, size);
        System.out.println("Remove element duplicate: " + Arrays.toString(brr));
        sc.close();
    }
}