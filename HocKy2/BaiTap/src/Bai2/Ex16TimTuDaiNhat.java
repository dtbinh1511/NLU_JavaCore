package Bai2;

import java.util.Scanner;

/**
 * Ex16TimTuDaiNhat
 */
public class Ex16TimTuDaiNhat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();// doc ca dong

        // tach tu
        String[] inputs = input.split(" ");

        // tim do dai
        int index = 0;
        int lenMax = 0;
        for (int i = 0; i < inputs.length; i++) {
            int len = inputs[i].length();
            if (len > lenMax) {
                lenMax = len;
                index = i;

            }
        }
        System.out.println("Word: " + inputs[index] + ", position: " + (index + 1) + ", length:x " + lenMax);
        sc.close();
    }
}