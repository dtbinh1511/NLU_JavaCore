package lab8_set_T.Du;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";

	public static final String fileName = "fit.txt";

	// Returns the number of unique tokens the file
	// data/hamlet.txt or fit.txt
	public static int countUnique() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		Set<String> strings = new HashSet<String>();
		while (input.hasNext()) {
			strings.add(input.next());
		}
		return strings.size();
	}

	// Prints out the number of times each unique token
	// appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public static void printWordCounts() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		Set<String> strings = new HashSet<String>();
		while (input.hasNext()) {
			strings.add(input.next());
		}
		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	// Prints out the number of times each unique token
	// appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order
	// of tokens
	// Example: An - 3, Bug - 10, ...
	public static void printWordCountsAlphabet() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		TreeSet<String> strings = new TreeSet<>();
		while (input.hasNext()) {
			strings.add(input.next());
		}
		Iterator<String> iterator = strings.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(countUnique());
//		printWordCounts();
		printWordCountsAlphabet();
		
	}
}
