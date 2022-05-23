package Bai1;
import java.util.Random;
import java.util.Scanner;

public class Ex5SinhSoNgauNhien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random random = new Random();
        int count = 0;

        while (true) {
            int rand = random.nextInt(100);
            count++;
            if (rand == n) {
                break;
            }
            System.out.println("Random numbers: " + rand + ", input: " + n);

        }
        System.out.println("Steps numbers: " + count);
        sc.close();
    }
}