package String;

public class Bai47MaHoa {

	public static void main(String[] args) {
		String s = "i am a boy.";
		int n;
		char s1;
//		char s3;
//		int s2;
		for (int i = 0; i < s.length(); i++) {
			n = s.charAt(i) + 3;
			s1 = (char) n;
			System.out.print(s1 + " ");
//			s2 = s1 - 3;
//			s3 =(char) s2;
//			System.out.print(s3 +" ");
		}
	}

}
