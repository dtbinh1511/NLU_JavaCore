package ThucHanhBuoi4;

public class Bai13 {
	public static void maHoa(String s, String[][] str) {
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

	public static void maHoaNguoc(String s1, String[][] str) {
		String[] arrStr = s1.split("");
		int m = 3;
		int n = 5;
		int k = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				str[j][i] = arrStr[k++];
			}
			if (k > s1.length()) {
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(str[i][j].replaceAll("-", " "));
			}
		}
	}

	public static void main(String[] args) {
		String s = "I am student   ";
		String[][] str = new String[3][5];
		maHoa(s, str);
		System.out.println("========================");
		String s1 = "Isn-ttau-md--e-";
		maHoaNguoc(s1, str);
	}

}
