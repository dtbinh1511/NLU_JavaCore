package LoopStructure;

import java.util.Scanner;

public class Bai19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a,b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int UCLN = 0;
        for (int i = 1; i < a || i < b; i++) {
            int x;
            if (a % i == 0 && b % i == 0) {
                x = i;
                if (x > UCLN) {
                    UCLN = x;
                }
            }
        }
        int BCLN = (a * b) / UCLN;
        System.out.println("Ước chung lớn nhất là: " + UCLN);
        System.out.println("Bội chung nhỏ nhất là: " + BCLN);
        sc.close();
    }
    // System.out.println("UCLN là: " + UCLN(a, b));
    // System.out.println("BCNN là: " + BCNN(a, b));
    // sc.close();
    // }
    // public static int UCLN(int a, int b) {
    // if (b == 0)
    // return a;
    // return UCLN(b, a % b);
    // }
    // public static int BCNN(int a, int b) {
    // return (a * b) / UCLN(a, b);
    // }
}
