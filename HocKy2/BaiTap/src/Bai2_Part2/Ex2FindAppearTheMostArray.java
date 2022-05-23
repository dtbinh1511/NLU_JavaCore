package Bai2_Part2;

import java.util.Scanner;

public class Ex2FindAppearTheMostArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number in array");
        int n = sc.nextInt();
        System.out.println("Enter array");
        int[] array = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            b[i] = -1;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    b[j] = 0;
                    count++;
                }
            }
            if (b[i] != 0) {
                System.out.printf("Element %d appear %d times.\n", array[i], count);
            }
            if (max < count) {
                max = count;
                index = i;
            }
        }
        System.out.printf("Element appear the most is: %d .", array[index]);
        sc.close();
    }
}