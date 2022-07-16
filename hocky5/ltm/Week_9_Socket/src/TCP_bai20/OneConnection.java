package TCP_bai20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class OneConnection extends Thread {
	Socket socket;
	List<Student> students;
	List<Student> result;

	public OneConnection(Socket socket) {
		super();
		this.socket = socket;
		students = createListStudent();
	}

	public void run() {
		try {
			BufferedReader netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter netOut = new PrintWriter(socket.getOutputStream(), true);

			netOut.println("Connected");
			while (true) {
				String request = netIn.readLine();
				if (request.equalsIgnoreCase("quit"))
					break;
				try {
					// phân tích + xử lý
					requestAnal(request);
					// gửi response
					netOut.println(result);
					netOut.flush();
				} catch (Exception e) {
					netOut.println(e.getMessage());
				}

			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void requestAnal(String request) throws MyException {
		String command, attr;
		StringTokenizer token = new StringTokenizer(request, " ");
		command = token.nextToken().trim();
		try {
			attr = token.nextToken().trim();

		} catch (NoSuchElementException e) {
			throw new MyException(MyException.ERROR_COMMAND, "Lỗi cú pháp");
		}

		switch (command) {
		case "findByName":
			String name = attr;
			result = findByName(name);
			break;
		case "findByAge":
			int age = Integer.parseInt(attr);
			result = findByAge(age);
			break;
		case "findByScore":
			double score = Double.parseDouble(attr);
			result = findByScore(score);
			break;
		}
	}

	public List<Student> createListStudent() {

		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Tín", 18, 23.75));
		students.add(new Student("Thảo", 20, 25.25));
		students.add(new Student("Thư", 18, 23.75));
		students.add(new Student("Tiến", 20, 24.75));
		students.add(new Student("Tú", 19, 25.75));
		students.add(new Student("Sương", 18, 26));
		students.add(new Student("Toàn", 18, 24));
		students.add(new Student("Trúc", 19, 24.25));
		students.add(new Student("Văn", 19, 24.25));
		students.add(new Student("Nhật", 18, 25));
		students.add(new Student("Thương", 18, 24.75));
		students.add(new Student("Trang", 19, 25));
		students.add(new Student("Hiếu", 18, 25.5));
		students.add(new Student("Hướng", 18, 23));
		students.add(new Student("Thịnh", 19, 23.25));
		students.add(new Student("Hoàng", 18, 23.5));
		students.add(new Student("Hòa", 19, 23.75));
		students.add(new Student("Duyên", 19, 23.62));
		students.add(new Student("Nhi", 18, 23.62));
		students.add(new Student("Phúc", 20, 23.62));

		return students;
	}

	public List<Student> findByName(String name) {
		List<Student> list = new ArrayList<Student>();
		for (Student student : students) {
			if (student.getName().equalsIgnoreCase(name)) {
				list.add(student);
			}
		}
		return list;
	}

	public List<Student> findByAge(int age) {
		List<Student> list = new ArrayList<Student>();
		for (Student student : students) {
			if (student.getAge() == age) {
				list.add(student);
			}
		}
		return list;
	}

	public List<Student> findByScore(double score) {
		List<Student> list = new ArrayList<Student>();
		for (Student student : students) {
			if (Double.valueOf(student.getScore()).equals(Double.valueOf(score))) {
				list.add(student);
			}
		}
		return list;
	}

}
