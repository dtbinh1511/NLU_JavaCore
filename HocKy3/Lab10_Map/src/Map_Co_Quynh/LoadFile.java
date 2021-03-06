package Map_Co_Quynh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LoadFile {
	public static HashMap<String, String> loadFile(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		HashMap<String, String> map = new HashMap<String, String>();
		String line = null;
		while (true) {
			line = reader.readLine();
			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, "\t");
			String key = tokens.nextToken();
			String value = tokens.nextToken();
			map.put(key, value);
		}
		return map;

	}
}
