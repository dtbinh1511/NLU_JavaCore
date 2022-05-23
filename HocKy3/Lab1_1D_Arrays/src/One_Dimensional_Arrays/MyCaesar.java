package One_Dimensional_Arrays;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char encryptChar(char c) {
		int index = 0;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c)
				index = (i + n) % 26;
		}
		return ALPHABET[index];
	}

	// Encrypt a text using the above function for encrypting a charater.
	public String encrypt(String input) {
		char[] chars = input.toCharArray();
		String res = "";
		for (int i = 0; i < chars.length; i++) {
			res += encryptChar(chars[i]) + "";
		}
		return res.toString();
	}

	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char decryptChar(char c) {
		int index = 0;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c)
				index = (i - n) % 26;
		}
		return ALPHABET[index];
	}

	// Decrypt a encrypted text using the above function for decrypting a charater.
	public String decrypt(String input) {
		char[] chars = input.toCharArray();
		String res = "";
		for (int i = 0; i < chars.length; i++) {
			res += decryptChar(chars[i]) + "";
		}
		return res;
	}

	public static void main(String[] args) {
		MyCaesar caesar = new MyCaesar(4);
		System.out.println(caesar.encryptChar('B'));
		System.out.println(caesar.decryptChar('F'));
		System.out.println(caesar.encrypt("BINH"));
		System.out.println(caesar.decrypt("FMRL"));
	}
}
