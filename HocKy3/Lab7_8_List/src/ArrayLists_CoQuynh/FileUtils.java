package ArrayLists_CoQuynh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;




public class FileUtils {
	public static ArrayList<Customer> loadFile(String name) throws IOException {
		ArrayList<Customer> result = new ArrayList<Customer>();
		BufferedReader reader = new BufferedReader(new FileReader(name));
		String line = null;
		while (true) {
			line = reader.readLine();
			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, "\t");

			result.add(new Customer(tokens.nextToken(), Integer.parseInt(tokens.nextToken()), tokens.nextToken()));
		}
		reader.close();
		return result;

	}
}
