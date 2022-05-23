package String;

import java.util.Scanner;

public class Bai43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.nextLine();
        System.out.println("Số ký tự: " + s.length());
        
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            System.out.println(s2);
        }

        StringBuilder input1 = new StringBuilder();
        input1.append(s);// chèn
        input1 = input1.reverse();
        System.out.println(input1);
        // for (int i = 0; i < input1.length(); i++)
        //     System.out.print(input1.charAt(i));

        sc.close();
    }
}