package Map_T_Du;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurrences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into above map (containing <word, its occurrences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		while (input.hasNext()) {
			String word = input.next();
			if (map.containsKey(word))
				map.put(word, map.get(word) + 1);
			else
				map.put(word, 1);
		}
	}

	// Returns the number of unique tokens the file data/hamlet.txt or fit.txt
	public int countUnique() {
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
//		System.out.println(map);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		TreeMap<String, Integer> res = new TreeMap<>(map);
		for (Entry<String, Integer> entry : res.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
//		System.out.println(res);

	}

	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp wc = new MyWordCountApp();
		wc.loadData();
//		System.out.println(wc.toString());
		System.out.println(wc.countUnique());
		wc.printWordCounts();
		System.out.println("================");
		wc.printWordCountsAlphabet();

	}
}
