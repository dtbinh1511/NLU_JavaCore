package Bai1;

import java.util.Scanner;

public class Ex14SoChinhPhuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter [m,n]");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int count = 0;
        for (int i = m; i < n; i++) {
            int res = (int) Math.sqrt(i);
            if (res * res == i) {
                System.out.print(i + "  ");
                count++;
            }
        }
        System.out.println("There are "+count+ " square numbers ");
        sc.close();
    }
}