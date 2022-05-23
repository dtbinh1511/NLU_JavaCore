package NK1;

public class CartPt {
	private int x, y;

	public CartPt(int x, int y) {
		this.x = x;
		this.y = y;
	}

////Khoảng cách từ điểm trên của hcn đến tâm O
//	public double distanToO() {
//		return Math.sqrt(this.x * this.x + this.y * this.y);
//	}

//Khoảng cách từ tâm của hình chữ nhật đến tâm 0
	public double distanceCenterToO(int dx, int dy) { 
		return Math.sqrt((this.x + dx/2) * (this.x + dx/2) + (this.y + dy/2) *(this.y + dy/2)); 
	}
	
	// Khoảng cách từ tâm đường tròn đến tâm O
	public double distanceToO() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

}