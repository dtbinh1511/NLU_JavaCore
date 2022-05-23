package test;

import controller.Graph;
import controller.UndirectedGraph;

public class WeekSevenTest {
	public static void main(String[] args) {
		System.out.println("-----------------Undirected Graph---------------");
		String pathKruskal = "file-test/kruskal.txt";
		
		Graph g = new UndirectedGraph(pathKruskal);
		System.out.println("This is matrix of you:");
		g.printMatrix();
		System.out.println();
		System.out.println("Kruskal algorithm");
		g.krusKal();
		
		System.out.println();
		System.out.println("Prim algorithm");
		g.prim(0);
	}
}
