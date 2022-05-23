package Execise3;

public abstract class AGallery implements IGallery{
protected String files;
protected int size;
protected AGallery(String files, int size) {
	super();
	this.files = files;
	this.size = size;
}
// tính thời gian download 1 file
public double timeToDownload(int speed) {
	return this.size/ speed;
}
// so sánh 1 kích cỡ file có lớn hơn 1 kích cỡ đã cho
public boolean smallerThan(double maxSize) {
	return this.size < maxSize;
}
// kiểm tra xem 1 file có cùng tên với tên đã cho?
public boolean sameName(String name) {
	return this.files.equals(name);
}
}
