package TCP_bai19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class OneConnection extends Thread {
	Socket socket;
	private String operator;
	private double operand1;
	private double operand2;

	public OneConnection(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run() {
		try {
			BufferedReader netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter netOut = new PrintWriter(socket.getOutputStream(), true);

			netOut.println("Connected");
			while (true) {
				// 1. Receive request
				String request = netIn.readLine();
				if (request.equalsIgnoreCase("quit"))
					break;

				// 2. Analysis request
				try {
					requestAnal(request);

					// 3. Xu ly
					double result = doCalculating(operator, operand1, operand2);

					// 4. Send response
					String response = request + " = " + result;
					netOut.println(response);
				} catch (MyException e) {
					netOut.println(e.getMessage());
				}
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 2. Analysis request
	public void requestAnal(String request) throws MyException {
		StringTokenizer token = new StringTokenizer(request, "+-*/");
		String sp1, sp2;
		try {
			sp1 = token.nextToken();
		} catch (NoSuchElementException e) {
			throw new MyException(MyException.OPERAND1_MISS, "Miss Operand 1");
		}
		try {
			sp2 = token.nextToken().trim();
		} catch (NoSuchElementException e) {
			throw new MyException(MyException.OPERAND2_MISS, "Miss Operand 2");
		}

		operator = request.substring(sp1.length(), sp1.length() + 1);
		try {
			operand1 = Double.parseDouble(sp1.trim());
		} catch (NumberFormatException e) {
			// loi toan hang ko phai so
			throw new MyException(MyException.OPERAND1_NOT_NUMBER, "Operand 1 is not number");
		}
		try {
			operand2 = Double.parseDouble(sp2);
		} catch (NumberFormatException e) {
			throw new MyException(MyException.OPERAND2_NOT_NUMBER, "Operand 2 is not number");

		}
	}

	// 3. Xu ly
	public double doCalculating(String operator, double operand1, double operand2) throws MyException {
		double result = 0;
		switch (operator) {
		case "+":
			result = operand1 + operand2;
			break;
		case "-":
			result = operand1 - operand2;
			break;
		case "*":
			result = operand1 * operand2;
			break;
		case "/":
			result = operand1 / operand2;
			if (Double.isInfinite(result)) {
				throw new MyException(MyException.DIVIDE_BY_ZERO, "Divide by zero");
			}
			break;
		}
		return result;
	}
}
