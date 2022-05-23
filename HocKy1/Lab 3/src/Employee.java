
public class Employee {
private String name;
private int hours;
public Employee(String name, int hours) {

	this.name = name;
	this.hours = hours;
}
//tien lam trong n gio
public int wage () {
	return (this.hours * 12);
	
}
// tien thue
public double tax () {
	if (this.wage() <= 240) {
		return 0;
	}
		else {if (this.wage() < 480)
			return 0.15 * this.wage();
		else {return 0.28 * this.wage();
		
	}
	
	}

	
}
// tien duoc huong khi tru thue
public double netpay () {
	return (this.wage() - this.tax());
	
}
//tien tang cua moi nguoi
public double raiseWage() {
	return (this.hours * 14) ;
	
}
//kiem tra nhan vien lam du so gio trong mot tuan
public boolean checkOverTime(double amount) {
	return (this.hours >= 100);
}
	
}

