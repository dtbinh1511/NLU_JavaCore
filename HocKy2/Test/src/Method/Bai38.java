package Method;

import java.util.Scanner;

public class Bai38 {
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        for (int i = 2; i < n; i++) {
            if (isPrime(i) == true) {
                System.out.print(i + " ");
            }
        }
        sc.close();
    }
}