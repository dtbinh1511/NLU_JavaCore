package LoopStructure;

import java.util.Scanner;

public class Bai24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter moneys send");
        int p = sc.nextInt();
        System.out.println("Enter month");
        int n = sc.nextInt();
        System.out.println("Enter interest rate (.)");
        double r = sc.nextDouble();
        double f = p * Math.pow((1 + r), n);
        System.out.printf("The money get is = %.1f", f+p);
        sc.close();
    }

}