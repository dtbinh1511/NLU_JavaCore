package TCP_bai20;

public class MyException extends Exception{
	public static final int ERROR_COMMAND = 1;
	int errorCode;

	public MyException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
}
