package Bai1_Part3;

public class ListReversible {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 100000; i < 999999; i++) {
            int x = 0;
            int m = i;
            while (m > 0) {
                x = x * 10 + m % 10;
                m /= 10;
            }
            if (x == i) {
                count++;
                System.out.print(i + " ");
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }
}