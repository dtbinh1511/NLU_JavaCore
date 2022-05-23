package Bai1;
import java.util.Scanner;

public class Ex6TongChanLe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x;
        int sum = 0;
        if (n % 2 == 0) {
            x = 2;
        } else {
            x = 1;
        }
        for (int i = x; i <= n; i+=2) {
            sum += i;
        }
        System.out.println("Result: " + sum);
        sc.close();
    }
}