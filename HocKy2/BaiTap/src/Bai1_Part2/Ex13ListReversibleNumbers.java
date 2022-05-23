package Bai1_Part2;

public class Ex13ListReversibleNumbers {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 100000; i < 999999; i++) {
            int x = 0;
            int n = i;
            while (n > 0) {
                x = x * 10 + n % 10;
                n /= 10;
            }
            if (x == i) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }
}