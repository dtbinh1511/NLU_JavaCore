package Bai1;
import java.util.Scanner;

/**
 * Ex7TongNghichDao
 */
public class Ex7TongNghichDao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum +=(double) 1/i;
        }
        System.out.println("Result: " + sum);
        sc.close();
    }

}