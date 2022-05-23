package test;

import controller.Graph;
import controller.UndirectedGraph;

public class WeekSixTest {
	public static void main(String[] args) {
		System.out.println("-----------------Undirected Graph---------------");
		String path = "file-test/kruskal.txt";
		Graph g = new UndirectedGraph(path);
		System.out.println("This is matrix of you:");
		g.printMatrix();
		System.out.println(" DFS tree Algorithm:");
		g.DFSTree(0);
		System.out.println("BFS tree");
		g.BFSTree(0);
		System.out.println("Kruskal algorithm:");
		g.krusKal();
	}
}
