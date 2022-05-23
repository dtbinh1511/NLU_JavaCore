package test;

import controller.DirectedGraph;
import controller.Graph;
import controller.UndirectedGraph;

public class WeekFourTest {
	public static void main(String[] args) {
		System.out.println("-------------------Undirected graph--------------------");
		Graph ug = new UndirectedGraph();
		System.out.println("Euler cycle of undirected graph : ");
		ug.loadData("file-test/EulerCycleUn.txt");
		ug.eulerCycle();
		System.out.println("Euler path of undirected graph : ");
		ug.loadData("file-test/EulerPathUn.txt");
		ug.eulerPath();
		
		System.out.println("-------------------Directed graph--------------------");
		String path="file-test/EulerCycleDir.txt";
		Graph dg =new DirectedGraph(path);
		System.out.println("Euler cycle of directed graph : ");
		dg.loadData(path);
		dg.eulerCycle();
		
		String dgpath="file-test/EulerPathDir.txt";
		System.out.println("Euler path of directed graph : ");
		Graph dgp =new DirectedGraph(dgpath);
		dgp.loadData(dgpath);
		dgp.eulerPath();
	}
}
