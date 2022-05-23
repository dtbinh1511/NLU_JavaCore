package Assignment;

import java.util.Scanner;

public class Angle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an angle number");
        int angle = sc.nextInt();

        double angleR = Math.toRadians(angle);
        double sin = Math.sin(angleR);
        double cosin = Math.cos(angleR);
        double tg = Math.tan(angleR);
        double cotg = 1 / tg;

        System.out.println("Angle sin = " + sin);
        System.out.println("Angle cosin = " + cosin);
        System.out.println("Angle tg = " + tg);
        System.out.println("Angle cotg = " + cotg);
        sc.close();
    }
}