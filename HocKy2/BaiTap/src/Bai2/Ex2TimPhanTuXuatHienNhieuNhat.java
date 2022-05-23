package Bai2;

import java.util.Scanner;

/**
 * Ex2TimPhanTuXuatHienNhieuNhat
 */
public class Ex2TimPhanTuXuatHienNhieuNhat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("Enter array");
        int[] arr = new int[n];
        int[] brr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            brr[i] = -1;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    brr[j] = 0;
                    count++;
                }
            }
            if (brr[i] != 0) {
                System.out.printf("Element %d appear %d lan\n", arr[i], count);
            }
            if (max < count) {
                max = count;
                index = i;
            }
        }
        System.out.printf("\nElement appear the most is: " + arr[index]);
        sc.close();
    }

}