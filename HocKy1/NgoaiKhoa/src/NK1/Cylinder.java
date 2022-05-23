package NK1;

public class Cylinder {
	private Circle baseDisk;
	private int height;

	public Cylinder(Circle baseDisk, int height) {
		super();
		this.baseDisk = baseDisk;
		this.height = height;
	}

// Tính thể tích hình trụ
	public double volume() {
		return this.baseDisk.area() * this.height;
	}

// TÍnh diện tích xung quanh hình trụ
	public double surfaceArea() {
		return this.baseDisk.perimeter() * this.height;
	}
}
