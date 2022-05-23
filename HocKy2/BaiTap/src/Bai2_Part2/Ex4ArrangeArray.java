package Bai2_Part2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex4ArrangeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers of array");
        int n = sc.nextInt();
        Random random = new Random();
        int count = 0;
        int[] a = new int[n];
        while (true) {
            a[count++] = random.nextInt(100);
            if (count == n) {
                break;
            }
        }
        Arrays.sort(a);
        System.out.println("Array a: " + Arrays.toString(a));

        int[] b = new int[n];
        int count1 = 0;
        boolean isExist = false;
        for (int i = 0; i < n; i++) {
            isExist = false;
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j]) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                b[count1++] = a[i];
            }
        }
        b = Arrays.copyOfRange(b, 0, count1);
        System.out.println("Remove duplicate elements: " + Arrays.toString(b));
        sc.close();
    }
}