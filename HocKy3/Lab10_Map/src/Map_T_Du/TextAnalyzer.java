package Map_T_Du;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader refered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int count = 1;
		while (true) {
			line = reader.readLine();
			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line + " ");
			while (tokens.hasMoreTokens()) {
				String word = tokens.nextToken();
				if (tokens.hasMoreTokens())
					add(word, count++);
				else
					add(word, count++ * -1);
			}
		}
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		if (!map.containsKey(word)) {
			ArrayList<Integer> value = new ArrayList<>();
			value.add(position);
			map.put(word, value);
		} else {
			ArrayList<Integer> value = map.get(word);
			value.add(position);
			map.put(word, value);
		}
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		for (Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + entry.getValue());
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		int count = 0;
		Set<String> set = map.keySet();
		for (String string : set) {
			count += map.get(string).size();
		}
		for (int i = 1; i < count; i++) {
			for (String string : set) {
				if (map.get(string).contains(i))
					System.out.print(string + " ");
				if (map.get(string).contains(-i))
					System.out.println(string);
			}
		}

	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		return null;
	}

	public static void main(String[] args) throws IOException {
		TextAnalyzer text = new TextAnalyzer();
		text.load("data/short.txt");
		text.displayWords();

//		text.displayText();
		

//		System.out.println(text.mostFrequentWord());
	}
}
