package LoopStructure;

import java.util.Scanner;

public class Bai17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        int count = 0;
        int result = 0;
        
        while (n != 0) {
            int du = n % 10;
            result = result * 10 + du;
            n = n / 10;
            count++;

        }
        System.out.println("Count digit is: " +count);
        System.out.println("Reverse number is: " + result);
        sc.close();

    }
}