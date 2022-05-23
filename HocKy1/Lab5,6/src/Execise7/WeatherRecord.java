package Execise7;

public class WeatherRecord {
private Date date;
private TemperatureRange today;
private TemperatureRange normal;
private TemperatureRange record;
private double precipitation;
public WeatherRecord(Date date, TemperatureRange today, TemperatureRange normal, TemperatureRange record,
		double precipitation) {
	this.date = date;
	this.today = today;
	this.normal = normal;
	this.record = record;
	this.precipitation = precipitation;
}
//Kiểm tra xem nhiệt độ hôm nay có là nhiệt độ bình thường ko
public boolean withinRange() {
	return this.today.withinRange(normal);
}
//Kiểm tra lượng mưa có cao hơn lượng mưa nhập vào hay ko
public boolean rainyDay (int precipitation) {
	return this.precipitation > precipitation;
	
}
//Kiểm tra nhiệt độ hôm nay có vượt quá nhiệt độ bình thường hay không?
public boolean recordDay() {
	return this.today.recordDay(record);
	
}
}
