package String;

import java.util.Scanner;

public class Bai44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        String s = sc.nextLine();
        // String s1 = sc.nextLine();
        System.out.println(s.toUpperCase());
        System.out.println(s.substring(0, 1).toUpperCase() + s.substring(1));
        sc.close();
    }
}