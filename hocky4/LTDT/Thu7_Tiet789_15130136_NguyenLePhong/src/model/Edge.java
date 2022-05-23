package model;

public class Edge {
	int x;
	int y;
	int w;
	public Edge(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Edge(int x,int y,int w){
		this.x=x;
		this.y=y;
		this.w=w;
	}
	
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Edge [x=" + x + ", y=" + y + ", w=" + w + "]";
	}
	
	
}
