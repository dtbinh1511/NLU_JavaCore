package test;

import controller.DirectedGraph;
import controller.Graph;
import controller.UndirectedGraph;

public class WeekTwoTest {
	public static void main(String[] args) {
		System.out.println("-------------------Undirected graph--------------------");
		String path = "file-test/MTUnGraph.txt";
		Graph g = new UndirectedGraph(path);
		System.out.println("This is matrix of you: ");
		g.printMatrix();
		System.out.println("Path from 2 to 5 is: ");
		g.findPathFromXToY(2, 5);
		System.out.println("Check continuity of graph is: "+((UndirectedGraph) g).checkConnected());
		
		System.out.println("-------------------Directed graph--------------------");
		String pathDir="file-test/MTDirGraph.txt";
		Graph gdir = new DirectedGraph(pathDir);
		System.out.println("This is matrix of you:");
		gdir.printMatrix();
		gdir.browseGraphWithDFS(0);
		System.out.println("Path from 0 to 3 is: ");
		gdir.findPathFromXToY(0, 3);
		System.out.println("Check continutity of graph: ");
		gdir.checkContinuityOfGraph();
	}
}
