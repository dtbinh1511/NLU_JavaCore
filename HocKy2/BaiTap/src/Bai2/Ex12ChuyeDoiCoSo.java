package Bai2;

import java.util.Scanner;


public class Ex12ChuyeDoiCoSo {
    public static final String BASE = "0123456789ABCDEFGHIJKLMNOPQRSTUVXYZW";

    public static String result(int n, int b) {
        StringBuilder builder = new StringBuilder();
        int x = 0;
        while (n > 0) {
            x = n % b;
            n /= b;
            builder.append(BASE.charAt(x));

        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, b;
        System.out.println("Enter value: ");
        n = sc.nextInt();
        b = sc.nextInt();
        System.out.println("Result: " + result(n, b));
        sc.close();
    }

}