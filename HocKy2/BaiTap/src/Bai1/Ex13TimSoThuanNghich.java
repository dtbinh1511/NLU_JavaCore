package Bai1;

public class Ex13TimSoThuanNghich {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 100000; i < 999999; i++) {
            int n = 0;
            int x = i;
            while (x > 0) {
                n = n * 10 + x % 10;
                x /= 10;
            }
            if (i == n) {
                System.out.print(i + "  ");
                count++;

                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }
}