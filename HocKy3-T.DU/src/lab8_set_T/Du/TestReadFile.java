package lab8_set_T.Du;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestReadFile {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("fit.txt"));
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
	}

}
