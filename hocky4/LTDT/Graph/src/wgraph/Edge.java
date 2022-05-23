package wgraph;

public class Edge {
	private int x;
	private int y;
	private double w;

	public Edge(int x, int y, double w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getW() {
		return w;
	}
	
}
