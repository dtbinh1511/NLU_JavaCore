package String;

public class StringHome {

	public static void main(StringHome[] args) {
		String s = "I am a boy.";
		String[] word = s.split("\\s", 4); // tách chuỗi dựa trên khoảng trắng có or không ,4
		for (String w : word) {
			System.out.println(w);
		}
		char c = '3';
		System.out.println(c);

		System.out.println("CharAt_lấy ký tự tại vị trí: " + s.charAt(7));

		System.out.println("concat_nối chữ: " + s.concat("I am study NLU"));

		// char(ASCII) + int
		System.out.println(c + 3);
		// check exit string
		System.out.println(s.contains("I'm 18 years old."));
		// check end word
		System.out.println(s.endsWith("."));
		// trả về vị trí mà kí tự đó đang đứng 0 -> n-1
		System.out.println(s.indexOf('I'));
		System.out.println(s.lastIndexOf("I"));
		// return string
		System.out.println(s.intern());
		// check string empty
		System.out.println(s.isEmpty());
		// length string
		System.out.println(s.length());
		// lấy từ vị trí đến vị trí
		System.out.println(s.substring(3, 9));

		char[] s1 = { 'A', 'B' };
		System.out.println(String.copyValueOf(s1));
		// check chuỗi có khớp với chuỗi ban đầu (.*) đại diện cho cụm từ,từ, ký tự
		System.out.println(s.matches("I(.*)"));

		// thay toàn bộ string thành string khác
		System.out.println(s.replaceAll("I am a boy.", "I am study NLU"));
		// thay toàn bộ ký tự này bằng ký tự khác
		System.out.println(s.replace('a', 'b'));
		// thay cụm từ này bằng cụm từ khác
		System.out.println(s.replaceFirst("boy", "man"));
		// dịch chuỗi sang hascode
		System.out.println(s.hashCode());
	}

}
