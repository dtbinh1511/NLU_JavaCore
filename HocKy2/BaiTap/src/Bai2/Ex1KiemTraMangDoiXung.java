package Bai2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1KiemTraMangDoiXung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("Enter array");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[]a1=Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1]=temp;
        }
        int[] a2 = Arrays.copyOf(arr,arr.length);
        if(Arrays.equals(a1, a2)){
            System.out.println(" Array Symmetry ");
        }else{
            System.out.println(" Array Not Symmetry ");
        }
       sc.close();
    }
}