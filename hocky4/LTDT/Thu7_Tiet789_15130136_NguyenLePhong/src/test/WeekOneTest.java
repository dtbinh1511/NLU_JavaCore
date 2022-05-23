package test;

import controller.DirectedGraph;
import controller.Graph;
import controller.UndirectedGraph;

public class WeekOneTest {
	public static void main(String[] args) {
		System.out.println("-------------------Undirected graph--------------------");
		String path = "file-test/MTUnGraph.txt";
		Graph g = new UndirectedGraph(path);
		System.out.println("This is matrix of you:");
		g.printMatrix();
		System.out.println("Browse Graph with DFS:");
		g.browseGraphWithDFS(0);
		System.out.println("Browse Graph with BFS:");
		g.browseGraphWithBFS(0);
		System.out.println("Degree top 0: " + g.topDegree(0));
		System.out.println("Sum edge of graph: " + g.edgeNum());
		System.out.println("Sum all degree top of graph: " + g.allTopDegree());
		
		
		
		System.out.println("-------------------Directed graph--------------------");
		String pathDir="file-test/MTDirGraph.txt";
		Graph gdir = new DirectedGraph(pathDir);
		System.out.println("This is matrix of you:");
		gdir.printMatrix();
		System.out.println("Browse Graph with DFS:");
		gdir.browseGraphWithDFS(0);
		System.out.println("Browse Graph with BFS:");
		gdir.browseGraphWithBFS(0);
		System.out.println("Degree top 0: "+gdir.topDegree(0));
		System.out.println("Degree top in 0: "+((DirectedGraph) gdir).topDegreeIn(0) );
		System.out.println("Degree top out 0: "+((DirectedGraph) gdir).topDegreeOut(0) );
		System.out.println("Sum edge of graph: "+gdir.edgeNum());
		System.out.println("Sum all degree top of graph: "+gdir.allTopDegree());
		
	}
}
