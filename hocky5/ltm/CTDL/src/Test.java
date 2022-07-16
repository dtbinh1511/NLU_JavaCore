

public class Test {
	int step;
	String strings;

	public Test(int step, String strings) {
		super();
		this.step = step;
		this.strings = strings;
	}

	public char[] encryt() {
		char[] re = new char[strings.length()];
		for (int i = 0; i < strings.length(); i++) {
			char c = (char) (strings.charAt(i) + step);
			if (c > 'z') {
				re[i] = (char) (c - 26);
			} else {
				re[i] = c;
			}
		}
		return re;
	}

	public char[] decryt() {
		// gan gia tri
		char[] encryt = encryt();
		
		char[] re = new char[encryt.length];
		for (int i = 0; i < encryt.length; i++) {
			char c = (char) (encryt[i] - step);
			if (c < 'a') {
				re[i] = (char) (c + 26);
			} else {
				re[i] = c;
			}
		}
		return re;
	}

	
	
	public static void main(String[] args) {
		String s = "abcxyz";
		int step = 1;
		Test c = new Test(step, s);
		System.out.println(c.encryt());
		System.out.println(c.decryt());

	}
}
