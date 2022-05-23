import java.util.Scanner;

public class BaiKoiCho {
	public static String CheckNum(int a) {
		switch (a) {
		case 1:
			return "Một";
		case 2:
			return "hai";
		case 3:
			return "ba";
		case 4:
			return "bốn";
		case 5:
			return "Năm";
		case 6:
			return "sáu";
		case 7:
			return "bảy";
		case 8:
			return "tám";
		case 9:
			return "chín";
		case 0:
			return "Không";
		default:
			return "nhập số không chính xác";
		}
	}

	public static int numOfDigits(int a) {
		int count = 0;
		do {
			a /= 10;
			count++;
		} while (a > 0);
		return count;
	}

	public static String callNumber(int a) {
		String[] n = { " ", " mươi ", " trăm ", " lẻ " };
		int b = a / 10;
		int c = a % 10;
		switch (numOfDigits(a)) {
		case 1:
			return CheckNum(a);
		case 2:
			if ((a < 20) && (a % 10 == 0)) {
				return "mười";
			} else if ((a < 20) && (a % 10 == 5)) {
				return "mười lăm";
			} else if (a < 20) {
				return "mười " + CheckNum(a % 10);
			} else if (c == 5) {
				return CheckNum(a / 10) + n[1] + "lăm";
			} else if (c == 1 && a > 20) {
				return CheckNum(a / 10) + n[1] + "mốt";
			} else {
				return CheckNum(a / 10) + n[1] + CheckNum(a % 10);
			}
		case 3:
			if (a % 100 == 0) {
				return CheckNum(a / 100) + n[2];
			} else if ((c == 5) && (!(b % 10 == 0))) {
				return CheckNum(a / 100) + n[2] + CheckNum(b % 10) + n[1] + "lăm";
			} else if (b % 10 == 0) {
				return CheckNum(a / 100) + n[2] + n[3] + CheckNum(a % 100);
			} else if (c == 1) {
				return CheckNum(a / 100) + n[2] + CheckNum(b % 10) + n[1] + "mốt";
			} else {
				return CheckNum(a / 100) + n[2] + CheckNum(b % 10) + n[1] + CheckNum(a % 10);
			}
		default:
			return "Error";
//			throw new IllegalArgumentException("Unexpected value: " + numOfDigits(a));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào 1 số : ");
		int a = sc.nextInt();
		System.out.println(callNumber(a));
	}
}
