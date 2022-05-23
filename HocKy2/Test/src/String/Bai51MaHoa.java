package String;


public class Bai51MaHoa {
	public static void main(String[] args) {
		String s = "I am student   ";
		String[][] str = new String[3][5];
		String str1[] = s.split("");
		
		int m = 3;
		int n = 5;
		int k = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				str[i][j] = str1[k];
				k++;
			}
			if (k > s.length()) {
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(str[j][i]);
				
			}
		}
//		System.out.println();
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(str[i][j]);
//			}
//			
//		}
	}

}
