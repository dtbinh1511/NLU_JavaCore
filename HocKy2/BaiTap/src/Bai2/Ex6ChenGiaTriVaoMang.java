package Bai2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ex6ChenGiaTriVaoMang
 */
public class Ex6ChenGiaTriVaoMang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();

        System.out.println("Enter array");
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter x");
        int x = sc.nextInt();

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                index = i;
                break;
            }
        }
        if (index == -1) {//inserted into the last position
            arr[n] = x;
        } //Translate all the elements to the right of the index position
        else {
            for (int i = n; i > index; i--) {
                arr[i] = arr[i - 1];// ex a[5] =  a[4] = Value at a[4]
            }
            arr[index]=x;

        }
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}