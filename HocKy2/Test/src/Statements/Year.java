package Statements;

import java.util.Scanner;

public class Year {
    static void leapYear(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year");
        int year = sc.nextInt();

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " is lead year.");
        } else {
            System.out.println(year + " isn't lead year.");
        }
    }
    static void numberDayInMonth() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter month");
        int month = sc.nextInt();
        System.out.println("Enter year");
        int year = sc.nextInt();
        int days = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
        }
        System.out.println("Number days in month:" + days);
        sc.close();
    }
    public static void main(String[] args) {
        leapYear();
        System.out.println();
        numberDayInMonth();
        
    }
}