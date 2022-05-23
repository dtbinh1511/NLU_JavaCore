package test;

import controller.Graph;
import controller.UndirectedGraph;

public class WeekEightTest {
	public static void main(String[] args) {
		System.out.println("-----------------Undirected Graph---------------");
		String path="file-test/Dijsktra.txt";
		Graph g = new UndirectedGraph(path);
		System.out.println("This is matrix of you:");
		g.printMatrix();
		System.out.println();
		System.out.println("Dijsktra Algorithm: ");
		g.dijsktra(0);
//		g.dijsktra(0,6);
//		g.dijsktra(0,4,6);
	}
}
