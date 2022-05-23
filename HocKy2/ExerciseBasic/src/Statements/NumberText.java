package Statements;

import java.util.Scanner;

public class NumberText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        String tram = " ";
        String chuc = " ";
        String donVi = "";
        int t = n / 100;
        int c = (n - t * 100) / 10;
        int d = (n - t * 100) % 10;
        switch (t) {
            case 1:
                tram = "Một trăm";
                break;
            case 2:
                tram = "Hai trăm";
                break;
            case 3:
                tram = "Ba trăm";
                break;
            case 4:
                tram = "Bốn trăm";
                break;
            case 5:
                tram = "Năm trăm";
                break;
            case 6:
                tram = "Sáu trăm";
                break;
            case 7:
                tram = "Bảy trăm";
                break;
            case 8:
                tram = "Tám trăm";
                break;
            case 9:
                tram = "Chín trăm";
                break;
        }
        switch (c) {
            case 0:
                if (c == 0 && d==0) {
                    chuc = "";
                } else {
                    chuc = " lẻ";
                }
                break;
            case 1:
                chuc = " Mười";
                break;
            case 2:
                chuc = " Hai mươi";
                break;
            case 3:
                chuc = " Ba mươi";
                break;
            case 4:
                chuc = " Bốn mươi";
                break;
            case 5:
                chuc = " Năm mươi";
                break;
            case 6:
                chuc = " Sáu mươi";
                break;
            case 7:
                chuc = " Bảy mươi";
                break;
            case 8:
                chuc = " Tám mươi";
                break;
            case 9:
                chuc = " Chín mươi";
                break;
        }
        switch (d) {
            case 0:
                if (n == 0) {
                    donVi = " Không";
                } else {
                    donVi = ".";
                }
                break;
            case 1:
                if (n == 1 || c == 1 || c == 0) {
                    donVi = " Một.";
                } else {
                    donVi = " Mốt.";
                }
                break;
            case 2:
                donVi = " Hai.";
                break;
            case 3:
                donVi = " Ba.";
                break;
            case 4:
                donVi = " Bốn.";
                break;
            case 5:
                if (n == 5) {
                    donVi = " Năm.";
                } else {
                    donVi = " lăm.";
                }
                break;
            case 6:
                donVi = " Sáu.";
                break;
            case 7:
                donVi = " Bảy.";
                break;
            case 8:
                donVi = " Tám.";
                break;
            case 9:
                donVi = " Chín.";
                break;
        }
        System.out.println(tram + chuc + donVi);
    }
}
