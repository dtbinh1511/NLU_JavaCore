package UCS;

import BFS_DFS.ISearchAlgo;
import BFS_DFS.Node;
import BFS_DFS.NodeUtils;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		Node nodeR = new Node("R");
		Node nodeQ = new Node("Q");
		Node nodeP = new Node("P");

		nodeS.addEdge(nodeD, 3);
		nodeS.addEdge(nodeE, 9);
		nodeS.addEdge(nodeP, 1);
		nodeD.addEdge(nodeB, 1);
		nodeD.addEdge(nodeC, 8);
		nodeD.addEdge(nodeE, 2);
		nodeE.addEdge(nodeR, 9);
		nodeE.addEdge(nodeH, 1);
		nodeP.addEdge(nodeQ, 15);
		nodeB.addEdge(nodeA, 2);
		nodeC.addEdge(nodeA, 2);
		nodeH.addEdge(nodeP, 4);
		nodeH.addEdge(nodeQ, 4);
		nodeQ.addEdge(nodeR, 3);
		nodeR.addEdge(nodeF, 5);
		nodeF.addEdge(nodeC, 5);
		nodeF.addEdge(nodeG, 5);

//		Node nodeS = new Node("S");
//		Node nodeA = new Node("A");
//		Node nodeB = new Node("B");
//		Node nodeC = new Node("C");
//		Node nodeD = new Node("D");
//		Node nodeE = new Node("E");
//		Node nodeF = new Node("F");
//		Node nodeG = new Node("G");
//		Node nodeH = new Node("H");
//
//		nodeS.addEdge(nodeA, 5);
//		nodeS.addEdge(nodeB, 2);
//		nodeS.addEdge(nodeC, 4);
//		nodeA.addEdge(nodeD, 9);
//		nodeA.addEdge(nodeE, 4);
//		nodeB.addEdge(nodeG, 6);
//		nodeC.addEdge(nodeF, 2);
//		nodeD.addEdge(nodeH, 7);
//		nodeE.addEdge(nodeG, 6);
//		nodeF.addEdge(nodeG, 1);
	
		ISearchAlgo algo = new UniformCostGraphSearchAlgo();
//		Node result = algo.execute(nodeS, "A", "G");
		Node result = algo.execute(nodeS, "G");
		
		System.out.print(NodeUtils.printPath(result) + " " + result.getPathCost());
	}
}
