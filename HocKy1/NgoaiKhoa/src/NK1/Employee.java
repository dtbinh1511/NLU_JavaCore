package NK1;

public class Employee {
	private String name;
	private int hours;

	public Employee(String name, int hours) {

		this.name = name;
		this.hours = hours;
	}

// Tiền trả công nhân sau n giờ làm bằng: số giờ nhân với 12
	public int wage() {
		return this.hours * 12;

	}

//Thuế thu nhập của người công nhân bằng: wage * 0.15
//public double tax() {
//	return this.wage() * 0.15;
//}
//Số tiền người công nhân nhận được sau khi trừ thuế bằng : wage- tax
//	public double netpay() {
//		return this.wage() - this.tax();
//	}

// Tiền lương tăng lên là 14 
	public int raisedWage() {
		return this.hours * 14;
	}

//Kiểm tra xem người công nhân làm việc có hơn 100 giờ trong tuần hay không
	public boolean checkOverTime() {
		return this.hours > 100;
	}

//Tính tiền thuế thu nhập theo mốc 
	public double tax() {
		if (this.wage() <= 240)
			return 0;
		else if (this.wage() <= 480)
			return this.wage() * 0.15;
		else
			return this.wage() * 0.28;

	}

// Số tiền người công nhân nhận được sau thuể
	public double netpay() {
		return (this.wage()- this.tax());
	}
}
