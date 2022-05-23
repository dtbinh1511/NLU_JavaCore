package ThucHanhBuoi3;

import java.util.Arrays;

public class Bai13 {

	public static void main(String[] args) {
		String s = "I am student   ";
		String[][] str = new String[3][5];
		translate(s, str);
		System.out.println("==========================");
		String S = "Isn-ttau-md--e-";
		translate2(S, str);
		
	}

	public static void translate(String s, String[][] str) {
		String str1[] = s.split("");
		int m = 3;
		int n = 5;
		int k = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				str[i][j] = str1[k++];
			}
			if (k > s.length()) {
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(str[j][i].replaceAll(" ", "-"));
			}
		}
		System.out.println();
	}

	public static void translate2(String S, String[][] str) {
		String[] s1 = S.split("");
		int k = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				str[j][i] = s1[k++];
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(str[i][j].replaceAll("-", " "));
			}
		}

	}

}
