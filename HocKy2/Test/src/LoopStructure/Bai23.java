package LoopStructure;

import java.util.Scanner;

public class Bai23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        int sum = 0;
        long multiply = 1;
        for (int i = 1; i <= n; i++) {
            sum += i;
            multiply *= i;
        }
        System.out.println("Sum = " + sum);
        System.out.println("Result = " + multiply);
        sc.close();

    }
}