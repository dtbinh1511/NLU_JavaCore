package lab1_T.Du;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MyCaesar {
	public static final char[] ALPHABET = new char[94];
	private int n;// shift steps (right shift)
	private File srcFile, desFile;

	public MyCaesar(int shiftSteps, File srcFile, File desFile) {
		for (int i = 0; i < ALPHABET.length; i++) {
			ALPHABET[i] = (char) (33 + i);
		}

		this.srcFile = srcFile;
		this.desFile = desFile;
		this.n = shiftSteps;
	}

	public int getIndex(char c) {
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i])
				return i;
		}
		return -1;
	}

	// Encrypt a text using the above function for encrypting a charater.
	public char encryptChar(char c) {
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i])
				return ALPHABET[((getIndex(c) + n) % ALPHABET.length)];
		}
		return c;
	}

	// Encrypt string
	public String encrypt(String input) {
		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = encryptChar(chars[i]);
		}
		return String.valueOf(chars);
	}

	// Decrypt a character according to the given shif steps.
	public char decryptChar(char c) {
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i])
				return ALPHABET[(getIndex(c) - n) % ALPHABET.length];
		}
		return c;
	}

	// Decrypt string
	public String decrypt(String input) {
		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = decryptChar(chars[i]);
		}
		return String.valueOf(chars);
	}

	public static void main(String[] args) {
		File srcFile = new File("srcFile");
		File desFile = new File("desFile");
		MyCaesar caesar = new MyCaesar(3, srcFile, desFile);
		
		System.out.println(caesar.encrypt("nguyen minh chau"));
		System.out.println(caesar.decrypt("qjx|hq plqk fkdx"));
	}
}
