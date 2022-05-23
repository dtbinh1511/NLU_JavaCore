package LoopStructure;

import java.util.Scanner;

public class Bai30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        long max = 0;
        long f0 = 1, f1 = 1, fn;
        for (int i = 2; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
            System.out.println(fn);

            if (max < fn) {
                max = fn;
            }
        }
        System.out.println("Vi trí n = " + max);
        sc.close();

    }
}