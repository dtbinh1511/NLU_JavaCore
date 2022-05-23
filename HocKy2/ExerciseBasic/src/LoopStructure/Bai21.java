package LoopStructure;

public class Bai21 {
    public static void main(String[] args) {
        double sin, cos, tan, cot;
        for (int i = 0; i <= 90; i += 5) {
            sin = Math.sin(i);
            cos = Math.cos(i);
            tan = Math.tan(i);
            cot = 1 / Math.tan(i);
            System.out.print("góc " + i + " độ: ");
            System.out.print("sin = " + sin + ",");
            System.out.print("cos = " + cos + ",");
            System.out.print("tan =" + tan + ",");
            System.out.print("cot =" + cot + ".");
            System.out.println();
        }
    }
}