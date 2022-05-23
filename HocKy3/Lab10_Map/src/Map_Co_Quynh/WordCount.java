package Map_Co_Quynh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCount {
	public static Map<String, Integer> readString(String fileName) {
		Map<String, Integer> res = new HashMap<String, Integer>();
		StringTokenizer tokens = new StringTokenizer(fileName, " ,.;:-!?()");
		while (tokens.hasMoreTokens()) {
			String words = tokens.nextToken();
			if (res.containsKey(words))
				res.put(words, res.get(words) + 1);
			else
				res.put(words, 1);
		}
		return res;
	}

	public static Map<String, Integer> readFile(String fileName) throws IOException {
		Map<String, Integer> res = new HashMap<String, Integer>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while (true) {
			line = reader.readLine();
			if (line == null)
				break;
			res.putAll(readString(line));
		}
		reader.close();
		return res;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(readString("love, me. love? my! dog"));
		System.out.println(readFile("data/fit.txt"));
	}
}
