package LoopStructure;

import java.util.Scanner;

public class Bai16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number ");
        int n;
        int sum = 0;
        int count = 0;
        double avg = 0;
        int max = 0;
        do {
            n = sc.nextInt();
            sum += n;
            count++;
            avg = (double) sum / count;
            if (n > max) {
                max = n;
            }
        } while (n > 0);
        System.out.println("Sum = " + sum);
        System.out.println("Avg = " + avg);
        System.out.println("Max = " + max);
        sc.close();
    }

}