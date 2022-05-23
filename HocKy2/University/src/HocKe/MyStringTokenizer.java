package HocKe;

public class MyStringTokenizer {
	private String input;
	private String delims;
	private char delim;
	private int[] markArray;
	private int counter = 1;

	public MyStringTokenizer(String input, String delims) {
		this.input = input;
		this.delims = delims;
	}

	public MyStringTokenizer(String input, char delim) {
		this.input = input;
		this.delim = delim;
	}

	public boolean hasMoreToken() {
		if (input.length() == 0) {
			return false;
		}
		return true;
	}

	public int countToken() {
		char[] charInput = input.toCharArray();
		char[] charDelim = delims.toCharArray();
		int result = (charDelim.length == 1) ? 0 : 1;
		boolean check = false;

		for (int i = 0; i < charInput.length; i++) {
			for (int j = 0; j < charDelim.length; j++) {
				if (charInput[i] == charDelim[j]) {
					result++;
					if (i == charInput.length - 1) {
						check = true;
					}
				}
			}
//			result = (check = true) ? (result / charDelim.length) : (result / charDelim.length) + 1;
		}
		return result;
	}

	public String nextToken() {
		String result = "";
		char[] charInput = input.toCharArray();
		char[] charDelim = delims.toCharArray();
		markArray = new int[charInput.length];
		int count = 1;
		for (int i = 0; i < charInput.length; i++) {
			for (int j = 0; j < charDelim.length; j++) {
				if (charInput[i] == charDelim[j]) {
					markArray[i] = -1;
				} else {
					if (markArray[i] != -1) {
						markArray[i] = count;
					}
				}
				if (j == charDelim.length - 1 && charInput[i] == charDelim[charDelim.length - 1]) {
					count++;
				}
			}
			System.out.print(markArray[i] + " ");
			if (markArray[i] == counter) {
				result = result + charInput[i];
			}

		}
		counter++;
		return result;
	}

	public static void main(String[] args) {
		MyStringTokenizer st = new MyStringTokenizer("Nguyen+-*/Van+-*/A+-*/", "+-*/");
		System.out.println(st.hasMoreToken());
		System.out.println(st.countToken());

		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());

	}

}
