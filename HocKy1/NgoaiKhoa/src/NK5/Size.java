package NK5;

public class Size {
	private int height, length, width;

	public Size(int height, int length, int width) {
		super();
		this.height = height;
		this.length = length;
		this.width = width;
	}

	public String toString() {
		return this.height + "x" + this.length + "x" + this.width;
	}
}
