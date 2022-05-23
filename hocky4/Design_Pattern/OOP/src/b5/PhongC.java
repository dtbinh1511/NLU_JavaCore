package b5;

public class PhongC extends Phong {
	public PhongC() {
		super("C", 100);
	}

	@Override
	public String toString() {
		return getLoaiPhong() + ",getGia()=" + getGia();
	}
}
