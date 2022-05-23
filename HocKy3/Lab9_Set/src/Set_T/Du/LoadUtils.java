package Set_T.Du;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadUtils {
	public static List<String> loadUtils(String fileName) throws FileNotFoundException {
		List<String> res = new ArrayList<>();
		Scanner input = new Scanner(new File(fileName));
		while (input.hasNext()) {
			String words = input.next();
			res.add(words);
		}
		return res;

	}
}
