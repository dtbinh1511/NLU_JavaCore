package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class LoadData {
	// doc du lieu tu file de ghi vao map
	public static HashMap<String, String> readFile(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		HashMap<String, String> result = new HashMap<String, String>();

		String line = reader.readLine();
		while (line != null) {
			StringTokenizer tokenizer = new StringTokenizer(line, "\t");//tach cac phan tu trong chuoi
			String key = tokenizer.nextToken();
			String value = tokenizer.nextToken();
			result.put(key, value);
			line = reader.readLine();
		}

		return result;
	}
}
