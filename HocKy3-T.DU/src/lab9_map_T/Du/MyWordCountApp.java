package lab9_map_T.Du;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";

	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	static Map<String, Integer> map = new HashMap<String, Integer>();

	// Returns the number of unique tokens the file data/hamlet.txt or fit.txt
	public static int countUnique() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileName));
		while (scanner.hasNext()) {
			String s = scanner.next();
			int o = count(s);
			map.put(s, o);
		}
		return map.size();
	}

	public static int count(String s) throws FileNotFoundException {
		int c = 0;
		Scanner scanner = new Scanner(new File(fileName));
		ArrayList<String> list = new ArrayList<>();
		while (scanner.hasNext()) {
			list.add(scanner.next());
		}
		for (String string : list) {
			if (s.equals(string))
				c++;
		}
		return c;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public static void printWordCounts() throws FileNotFoundException {
		System.out.println(map);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public static void printWordCountsAlphabet() {
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String s = iterator.next();
			System.out.println(s + " - " + map.get(s));
		}

	}

	public static void main(String[] args) {
		try {
			System.out.println(countUnique());
			printWordCounts();
			printWordCountsAlphabet();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
