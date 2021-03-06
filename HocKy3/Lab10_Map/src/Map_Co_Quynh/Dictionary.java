package Map_Co_Quynh;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Dictionary {
	private Map<String, String> map;

	public void loadFile(String fileName) throws IOException {
		map = LoadFile.loadFile(fileName);
	}

	public String findVocabulary(String vocabulary) {
		Set<String> set = map.keySet();
		StringBuilder builder = new StringBuilder();

		for (String string : set) {
			if (string.indexOf(vocabulary) != -1)
				builder.append(string + ": " + map.get(string) + "\n");
		}
		return (builder.length() == 0) ? "Không tìm thấy" : builder.toString();
	}

	public void add(String eng, String vn) {
			if (!map.containsKey(eng))
				map.put(eng, vn);
			else {
				map.put(eng, map.get(eng)+ "," + vn);
			}
		
	}

	public static void main(String[] args) throws IOException {
		Dictionary dictionary = new Dictionary();
		dictionary.loadFile("data/data.txt");
		dictionary.add("app", "Phần mềm");
		dictionary.add("apple", "Quả táo");
		System.out.println(dictionary.findVocabulary("app"));
	}
}
