package String;

public class Bai48MaHoaThongDiep {

	public static void main(String[] args) {
		String s = "i am a boy";
		int k = 5;
		int l = 2;
		maHoa(s);
	}

	public static void maHoa(String s) {
		int k = 5;
		int l = 2;
		String[] str = s.split(" ");
		for (int i = 0; i < str.length; i++) {
			String s1 = str[i];
			for (int j = 0; j < s1.length(); j++) {
				if (i % 2 == 0) {
					int n = s1.charAt(j) + k;
					char s2 = (char) n;
					System.out.print(s2 + " ");
				} else {
					int n = s1.charAt(j) - l;   
					char s2 = (char) n;
					System.out.print(s2 + " ");
				}
			}

		}

	}

}
