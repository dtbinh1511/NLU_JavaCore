package Bai2;

/**
 * Ex13CheckXauThuanNghich
 */
public class Ex13CheckXauThuanNghich {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 100000000; i < 999999999; i++) {
            if (isReversible( i + "")) {
                System.out.printf("%12d", i);
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }

        }
    }

    public static boolean isReversible(String s) {
        String other;
        StringBuilder stringBuilder = new StringBuilder(s);
        other = stringBuilder.reverse().toString();

        return (s.compareTo(other) == 0);
    }
}