package Bai1_Part3;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        Random random = new Random();
        int count = 0;
        while (true) {
            int x = random.nextInt(100);
            count++;
            if (x == n) {
                break;
            }
            System.out.printf("Random Number :%3d,input:%2d.", x, n);
            System.out.println();
        }
        System.out.println("Steps number: " + count);
        sc.close();
    }
}