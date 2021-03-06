package tinhtoan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class OneConnection extends Thread {
	public Socket socket;
	public BufferedReader netIn;
	public PrintWriter netOut;

	public String operator;
	public double operand1;
	public double operand2;

	public OneConnection(Socket socket) throws IOException {
		this.socket = socket;
		netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		netOut = new PrintWriter(socket.getOutputStream(), true);
		netOut.println("Connected");
	}

	public void run() {
		try {
			while (true) {
				// nhận yêu cầu
				String recieve = netIn.readLine();
				if (recieve.equalsIgnoreCase("quit")) {
					break;
				}

				// xử lý yêu cầu
				try {
					requestAnlys(recieve);
					// phản hồi
					double res = doCalculator(operand1, operand2, operator);
					String respone = recieve + " = " + res;
					netOut.println(respone);
				} catch (MyException e) {
					netOut.println(e.getMessage());
				}

				// đóng
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void requestAnlys(String request) throws MyException {
		StringTokenizer token = new StringTokenizer(request, "+-*/");
		String sp1, sp2;
		try {
			sp1 = token.nextToken();
		} catch (NoSuchElementException e) {
			throw new MyException("Miss Operand 1");
		}
		try {
			sp2 = token.nextToken().trim();
		} catch (NoSuchElementException e) {
			throw new MyException("Miss Operand 2");
		}

		operator = request.substring(sp1.length(), sp1.length() + 1);
		try {
			operand1 = Double.parseDouble(sp1.trim());
		} catch (NumberFormatException e) {
			throw new MyException("Operand 1 is not number");
		}
		try {
			operand2 = Double.parseDouble(sp2.trim());
		} catch (NumberFormatException e) {
			throw new MyException("Operand 2 is not number");
		}
	}

	private double doCalculator(double operand1, double operand2, String operator) throws MyException {
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
			if (Double.isInfinite(result))
				throw new MyException("Divide by zero");
			break;
		}

		return result;
	}

}
