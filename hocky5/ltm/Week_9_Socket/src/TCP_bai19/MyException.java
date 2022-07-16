package TCP_bai19;

public class MyException extends Exception {
	public static final int OPERAND1_NOT_NUMBER = 1;
	public static final int OPERAND2_NOT_NUMBER = 2;
	public static final int OPERAND2_MISS = 3;
	public static final int OPERAND1_MISS = 4;
	public static final int DIVIDE_BY_ZERO = 5;
	int errorCode;

	public MyException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
}
