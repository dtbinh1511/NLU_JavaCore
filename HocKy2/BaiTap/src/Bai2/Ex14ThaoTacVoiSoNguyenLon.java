package Bai2;

import java.math.BigInteger;

/**
 * Ex14ThaoTacVoiSoNguyenLon
 */
public class Ex14ThaoTacVoiSoNguyenLon {

    public static void main(String[] args) {
        BigInteger number1, number2;
        number1 = new BigInteger("44444444444444444444444444444444444");
        number2 = new BigInteger("99999999999999999999999999999999999");

        System.out.println("Tong: " + number1.add(number2));
        System.out.println("Hieu: " + number1.subtract(number2));
        System.out.println("Tich: " + number1.multiply(number2));
        System.out.println("Thuong: " + number2.divide(number1));
    }
}