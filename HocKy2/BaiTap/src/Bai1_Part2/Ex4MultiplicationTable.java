package Bai1_Part2;

public class Ex4MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf(" %1d x %1d = %2d ", j, i, i * j);
            }
            System.out.println();
        }
    }
}