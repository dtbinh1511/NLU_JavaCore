package Statements;

import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two number");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int max = Math.max(a, b);
        System.out.println("Number max is: " + max);
        sc.close();
    }
}