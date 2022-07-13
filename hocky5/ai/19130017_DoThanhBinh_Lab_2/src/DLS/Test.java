package DLS;

import BFS_DFS.Node;
import BFS_DFS.NodeUtils;

public class Test {
	public static void main(String[] args) {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeI = new Node("I");
		Node nodeJ = new Node("J");
		Node nodeK = new Node("K");
		Node nodeO = new Node("O");
		Node nodeP = new Node("P");
		Node nodeG = new Node("G");
		Node nodeL = new Node("L");
		Node nodeR = new Node("R");
		Node nodeH = new Node("H");
		Node nodeM = new Node("M");
		Node nodeN = new Node("N");
		Node nodeS = new Node("S");
		
		nodeA.addEdge(nodeB);
		nodeA.addEdge(nodeC);
		nodeA.addEdge(nodeD);
		
		nodeB.addEdge(nodeE);
		nodeB.addEdge(nodeF);
		nodeE.addEdge(nodeI);
		nodeF.addEdge(nodeJ);
		nodeF.addEdge(nodeK);
		nodeK.addEdge(nodeO);
		nodeK.addEdge(nodeP);
		
		nodeC.addEdge(nodeG);
		nodeG.addEdge(nodeL);
		nodeL.addEdge(nodeR);
		
		nodeD.addEdge(nodeH);
		nodeH.addEdge(nodeM);
		nodeH.addEdge(nodeN);
		nodeN.addEdge(nodeS);

		DepthLimitedSearchAlgo limited = new DepthLimitedSearchAlgo();
		Node result = limited.execute(nodeA, "R", 4);
		try {
			System.out.println(NodeUtils.printPath(result));
		} catch (NullPointerException e) {
			System.out.println("Null");
		}
	}
}
