package ThucHanhBuoi3;

import java.util.Scanner;

public class Bai11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a date: ");
		String str = sc.next();
		tranlate(str);
	}

	public static void tranlate(String str) {
		String[] s = str.split("/");
		String month = "";
		switch (s[1]) {
		case "1":
			month = " January ";
			break;
		case "2":
			month = " February ";
			break;
		case "3":
			month = " March ";
			break;
		case "4":
			month = " April ";
			break;
		case "5":
			month = " May ";
			break;
		case "6":
			month = " June ";
			break;
		case "7":
			month = " July ";
			break;
		case "8":
			month = " August ";
			break;
		case "9":
			month = " September ";
			break;
		case "10":
			month = " October ";
			break;
		case "11":
			month = " November ";
			break;
		case "12":
			month = " December ";
			break;
		default:
			System.out.println("Error");
			break;
		}
		System.out.println(s[0] + month + s[2]);
	}

}
