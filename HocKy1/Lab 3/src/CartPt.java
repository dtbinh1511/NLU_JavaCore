
public class CartPt {
private int x;
private int y;
public CartPt(int x, int y) {
	
	this.x = x;
	this.y = y;
}
// tinh do dai tu mot diem toi tam O
public double distanceToO() {
	return Math.sqrt((this.x * this.x ) + (this.y * this.y));
}
//tinh do dai canh bat ky
public double distanceTo (CartPt that) {
	return Math.sqrt( (that.x - this.x ) * (that.x - this.x ) + (that.y - this.y) * (that.y - this.y));
	
}
}
