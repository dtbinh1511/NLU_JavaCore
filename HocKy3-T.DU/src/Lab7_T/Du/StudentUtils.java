package Lab7_T.Du;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentUtils {

	public static ArrayList<Student> loadStudents(String fileName) throws IOException {

		ArrayList<Student> result = new ArrayList<Student>();

		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		String line = null;

		while (true) {
			line = reader.readLine();

			if (line == null)
				break;

			StringTokenizer token = new StringTokenizer(line, "\t");
			String id = token.nextToken();
			String firstName = token.nextToken();
			String lastName = token.nextToken();
			int birthYear = Integer.parseInt(token.nextToken());
			double gpa = Double.parseDouble(token.nextToken());

			result.add(new Student(id, firstName, lastName, birthYear, gpa));

		}
		reader.close();
		return result;

	}
}
