package b5;

public class PhongB extends Phong {
	public PhongB() {
		super("B", 300);
	}

	@Override
	public String toString() {
		return getLoaiPhong() + ",getGia()=" + getGia();
	}
}
