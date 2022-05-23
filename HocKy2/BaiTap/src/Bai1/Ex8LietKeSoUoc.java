package Bai1;
import java.util.Scanner;

public class Ex8LietKeSoUoc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("\nThere are " + count + " divisor.");
        sc.close();
    }
}