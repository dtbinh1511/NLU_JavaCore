package Bai1_Part2;

import java.util.Scanner;

public class Ex6TotalParity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        int x;
        int sum = 0;
        if (n % 2 == 0) {
            x = 2;
            System.out.print("Result is total even numbers: ");
        } else {
            x = 1;
            System.out.print("Result is total odd numbers: ");
        }
        for (int i = x; i <= n; i += 2) {
            sum += i;
        }
        System.out.print(sum);
        sc.close();
    }
}