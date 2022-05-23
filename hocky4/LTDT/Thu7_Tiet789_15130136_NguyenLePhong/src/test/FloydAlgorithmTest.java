package test;

import controller.DirectedGraph;
import controller.Graph;

public class FloydAlgorithmTest {
	public static void main(String[] args) {
		System.out.println("-----------------Undirected Graph---------------");
		String path="file-test/Floyd.txt";
		Graph g = new DirectedGraph(path);
		System.out.println("This is matrix of you:");
		g.printMatrix();
		System.out.println("Floyd Alogorithm: ");
		((DirectedGraph) g).floyd(0,5);
	}
}
