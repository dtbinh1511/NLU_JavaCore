package NK4;

public class Specification {
	private int baseDiameter;
	private int height;

	public Specification(int baseDiameter, int height) {
		this.baseDiameter = baseDiameter;
		this.height = height;
	}

	// Thể tích
	public double volumn() {
		return (this.height * Math.PI * Math.pow(this.baseDiameter / 2, 2));
	}

	// Kiểm tra xem thể tích có nhỏ hơn thể tích khác
	public boolean lessThan(Specification other) {
		return this.volumn() < other.volumn();
	}
}
