package Statements;

import java.util.Scanner;

public class Equation {
    static void quadraticEquation() {
        // ax+b=0
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coefficient a ,b,c");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        float c = sc.nextFloat();

        if (a == 0) {
            System.out.println("Equation has 1 root");
            if (b != 0) {
                System.out.println("Equation has root x = " + -c / b);
            } else if (c != 0) {
                System.out.println("Equation not root.");
            } else {
                System.out.println("Countless root.");
            }// linear equation
        } else {
            float delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("Equation not root.");
            } else if (delta == 0) {
                System.out.println("Equation multiple root x = " + -b / (2 * a));
            } else {
                float x1 = ((-b + (float) Math.sqrt(delta)) / 2 * a);
                float x2 = ((-b - (float) Math.sqrt(delta)) / 2 * a);
                System.out.println("Equation double root");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        }
        sc.close();
    }

}