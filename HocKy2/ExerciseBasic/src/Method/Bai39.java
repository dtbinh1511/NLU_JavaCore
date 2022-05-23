package Method;

import java.util.Scanner;

public class Bai39 {
    public static int UCLN(int a, int b) {
        if (b == 0)
            return a;
        return UCLN(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 number");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int uc = UCLN(a, b);
        System.out.println("Ước chung lớn nhất của ba số là: " + UCLN(uc, c));
        sc.close();
    }

}