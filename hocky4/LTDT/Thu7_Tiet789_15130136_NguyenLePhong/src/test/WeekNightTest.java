package test;

import controller.Graph;
import controller.UndirectedGraph;

public class WeekNightTest {
	public static void main(String[] args) {
		System.out.println("-----------------Undirected Graph---------------");
		String path = "file-test/bellman-ford.txt";
		Graph g = new UndirectedGraph(path);
		g.printMatrix();
		System.out.println("--------------------------------");
		g.bellmanFord(5);
		g.viewPathBellmanFord(5, g.P, g.L);
		System.out.println("--------------------------------");
		g.bellmanFord(5,0);
	}
}
