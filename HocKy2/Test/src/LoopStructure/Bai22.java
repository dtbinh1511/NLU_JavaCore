package LoopStructure;

public class Bai22 {
    public static void main(String[] args) {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf(" %1d x %1d = %2d ", j, i, i * j);
            }
            System.out.println();
        }
    }
}