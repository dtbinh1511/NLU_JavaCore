package NK1;

public class Entry {
private Date date;
private double distance;
private int duration;
private String comment;
public Entry(Date date, double distance, int duration, String comment) { 
	this.date = date;
	this.distance = distance;
	this.duration = duration;
	this.comment = comment;
}
//Tốc độ của người chạy
public double speed() {
	return this.distance / this.duration;
}
// Kiểm tra xem một ngày có sớm hơn ngày khác không
public boolean DateEarlier(Entry other) {
	return this.date.DateEarlier(date);
}
}
