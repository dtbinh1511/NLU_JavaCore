package LoopStructure;

import java.util.Scanner;

public class Bai25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("Enter x");
        int x = sc.nextInt();
        long sum = 0;
        long sum2 = 0;
        double sum3 = 0;
        long giaiThua = 1;

        for (int i = 0; i <= n; i++) {
            sum += Math.pow(x, i);
            sum2 += Math.pow(-x, i);
            if (i >= 2) {
                giaiThua *= (long) i;
            } else {
                giaiThua = 1;
            }
            sum3 += (Math.pow(x, i) / giaiThua);
        }
        System.out.println("sum 1 = " + sum);
        System.out.println("sum 2 = " + sum2);
        System.out.println("sum 3 = " + sum3);
        sc.close();
    }
}