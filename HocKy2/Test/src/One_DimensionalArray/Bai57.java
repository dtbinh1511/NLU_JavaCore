package One_DimensionalArray;

import java.util.Scanner;

public class Bai57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number element of array");
        int n = sc.nextInt();
        int x = sc.nextInt();
        System.out.println("Enter element of array");
        int[] a = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = -1;
        }
        int index = 0;
        int count = 0;
        boolean isExist = false;
        for (int i = 0; i < n; i++) {
            if (x == a[i]) {
                count++;
                index = i;
                System.out.printf("Appear %d  times, at position %d\n", count, index);
                isExist = true;
            }
        }
        System.out.println("x appear in array? " + isExist);
        //cau c
        sc.close();
    }
}