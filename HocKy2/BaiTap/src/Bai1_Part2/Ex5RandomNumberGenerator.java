package Bai1_Part2;

import java.util.Random;
import java.util.Scanner;

public class Ex5RandomNumberGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        int count = 0;
        Random random = new Random();
        while (true) {
            int ran = random.nextInt(100);
            count++;
            System.out.println("Random number: " + ran + ", input: " + n);
            if (ran == n) {
                break;
            }
        }
        System.out.println("Steps number: " + count);
        sc.close();
    }
}
