package Bai1_Part2;

import java.util.Scanner;

public class Ex7TotalInverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (double) 1 / i;
        }
        System.out.println("Total Inverse is: " + sum);
        sc.close();
    }
}