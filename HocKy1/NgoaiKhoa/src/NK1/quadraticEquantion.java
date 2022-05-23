package NK1;

public class quadraticEquantion {
	private int a, b, c;

	public quadraticEquantion(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

// Tính phương trình bậc hai vô nghiệm hay có nghiệm hay suy biến không
	public String whatKind() {
		if (b * b - 4 * a * c > 0)
			return "two";
		else if (b * b - 4 * a * c == 0)
			return "one";
		else if (a == 0 && b == 0)
			return "degenerate";
		else
			return "none";

	}
}
