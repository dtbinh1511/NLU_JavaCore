package Bai2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Ex4ArrangeArrayRandom
 */
public class Ex4ArrangeArrayRandom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.print("Create array random: ");
        int[] arr = new int[n];
        Random random = new Random();
        int count = 0;
        while (count < n) {
            arr[count++] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Arranged Array: " + Arrays.toString(arr));

        int[] brr = new int[n];
        int size = 0;
        boolean isExist = false;

        for (int i = 0; i < n; i++) {
            isExist = false;
            for (int j = 0; j < size; j++) {
                if (arr[i] == brr[j]) {// error brr[i]
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {// not exist in array
                brr[size++] = arr[i];
            }
        }

        brr = Arrays.copyOfRange(brr, 0, size);

        System.out.println("Remove duplicate elements: " + Arrays.toString(brr));
        sc.close();
    }
}