package One_DimensionalArray;

import java.util.Scanner;

public class Bai54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number element of array");
        int n = sc.nextInt();
        System.out.println("Enter element of array");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                count++;
                if (a[i] < min) {
                    min = a[i];
                }
                sum1 += a[i];
            }
            if (a[i] == 0) {
                count1++;
            }
            if (a[i] < 0) {
                count2++;
                if (a[i] > max) {
                    max = a[i];
                }
                sum2 += Math.abs(a[i]);
            }
        }

        System.out.printf("Số âm: %d,số dương: %d,số 0: %d\n", count2, count, count1);
        System.out.printf("Số âm lớn nhất: %d,số dương nhỏ nhất: %d \n", max, min);
        System.out.print("Tổng số âm với số dương có bằng nhau không? ");
        System.out.println(sum1 == sum2);
        sc.close();
    }
}