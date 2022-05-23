package String;

public class ThayTheChuoi {

	public static void main(String[] args) {
		String s = "i am a boy, a boy";
		String s1 = "a boy";
		String s2 = "a study";
//		 tìm và thay thế tất cả
		System.out.println(s.replaceAll(s1, s2));
	}

}
