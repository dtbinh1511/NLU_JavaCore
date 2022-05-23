package Execise7;

public class TemperatureRange {
private int low;
private int high;
public TemperatureRange(int low, int high) {
	super();
	this.low = low;
	this.high = high;
}
//Kiểm tra xem nhiệt độ hôm nay có là nhiệt độ bình thường ko
public boolean withinRange(TemperatureRange normal) {
	return (this.low > normal.low) && (this.high < normal.high);
}
//Kiểm tra nhiệt độ hôm nay có vượt quá nhiệt độ bình thường hay không?
public boolean recordDay(TemperatureRange record) {
	return (this.low < record.low || this.high > record.high);
}
}
