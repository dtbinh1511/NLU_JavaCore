package b5;

public class Test1 {
	public static void main(String[] args) {
		Phong a = new PhongA();
		Phong b = new PhongB();
		Phong c = new PhongC();
		Nguoi nguoi = new Nguoi("A", 21, 1232321, 2, a);
		KhachSan ks = new KhachSan();
		System.out.println(ks.add(nguoi));
		System.out.println(ks.show());
		System.out.println(ks.thanhTien(1232321));
	}
}
