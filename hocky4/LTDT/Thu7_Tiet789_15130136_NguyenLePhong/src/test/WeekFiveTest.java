package test;

import controller.DirectedGraph;
import controller.Graph;
import controller.UndirectedGraph;

public class WeekFiveTest {
	public static void main(String[] args) {
		System.out.println("-------------------Undirected graph--------------------");
		System.out.println("Cycles UnDirected Graph example");
		String unCycles ="file-test/UnHamiltonCycle.txt";
		Graph g = new UndirectedGraph(unCycles);
		g.printMatrix();
		g.hamiltonianCycle(0);
		
		
		System.out.println("Path Graph example");
		String unPath ="file-test/UnHamiltonPath.txt";
		Graph ughp = new UndirectedGraph(unPath);
		ughp.printMatrix();
		ughp.hamiltonianPath();
		
		System.out.println("-------------------Directed graph--------------------");
		System.out.println("Cycles Directed Graph example");
		
		String dirPath = "file-test/dirHamiltonCycle.txt";
		Graph g2 = new DirectedGraph(dirPath);
		g2.printMatrix();
		g2.hamiltonianCycle(0);
		
	}
}
