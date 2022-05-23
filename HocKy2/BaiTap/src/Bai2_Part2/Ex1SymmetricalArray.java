package Bai2_Part2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ex1SymmetricalArray
 */
public class Ex1SymmetricalArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total element");
        int n = sc.nextInt();

        System.out.println("Enter array ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int[] a1 = Arrays.copyOf(array, array.length);

        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
        
        int[] a2 = Arrays.copyOf(array, array.length);
        if (Arrays.toString(a1).equals(Arrays.toString(a2))) {
            System.out.println("Symmetrical Array");
        } else {
            System.out.println("Not Symmetrical Array");
        }
        sc.close();
    }

}