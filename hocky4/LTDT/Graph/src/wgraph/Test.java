package wgraph;

public class Test {
	public static void main(String[] args) {
		WGraph w = new WGraph(5);

		w.addEdge(0, 1, 1);
		w.addEdge(0, 2, 5);
		w.addEdge(0, 4, 6);
		w.addEdge(1, 2, 3);
		w.addEdge(1, 4, 2);
		w.addEdge(2, 4, 3);
		w.addEdge(3, 4, 2);

		w.floyd();
	}
}
