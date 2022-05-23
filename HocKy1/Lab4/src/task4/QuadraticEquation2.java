package task4;

public class QuadraticEquation2 {
	private int a, b, c;

	public QuadraticEquation2(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public String whatKind() {
		if (b * b - 4 * a * c > 0)
			return "two";
		else if (b * b - 4 * a * c == 0)
			return "one";
		else if ((a == 0) && (b == 0))
			return "degenerate";
		else
			return "none";
	}
}
