package LoopStructure;

public class Bai28 {
    

    public static void main(String[] args) {
        int x;
        for (int i = 9; i < 25; i++) {
            if ((i * 2 + (36 - i) * 4) == 100) {
                x = i;
                int y = 36 - x;
                System.out.println("Số gà là: " + x);
                System.out.println("Số chó là: " + y);
            }

        }

    }
}