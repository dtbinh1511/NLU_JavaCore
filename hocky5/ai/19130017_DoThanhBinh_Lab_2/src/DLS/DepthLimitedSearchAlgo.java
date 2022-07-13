package DLS;

import java.util.List;

import BFS_DFS.Edge;
import BFS_DFS.Node;

public class DepthLimitedSearchAlgo {

	public Node execute(Node root, String goal, int limitedDepth) {

		if (root.getLabel().equals(goal))
			return root;
		if (limitedDepth == 0)
			return null;

		List<Edge> edges = root.getChildren();
		for (Edge edge : edges) {
			Node child = edge.getEnd();
			child.setParent(root);
			
			Node result = execute(child, goal, limitedDepth - 1);
			if (result != null)
				return result;
		}

		return null;
	}

}
