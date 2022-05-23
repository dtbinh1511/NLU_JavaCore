package test;

import controller.Graph;
import controller.UndirectedGraph;

public class WeekThreeTest {
	public static void main(String[] args) {
		Graph g = new UndirectedGraph();
		g.loadData("file-test/MTLienThong.txt");
		System.out.println("This is matrix of you:");
		g.printMatrix();
		System.out.println("Find components continuity of graph: ");
		g.findConponentsContinuity();
	}
}
