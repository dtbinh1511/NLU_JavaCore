package SearchAlgo;

import java.util.Comparator;


public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		Double cost1 = o1.getPathCost();
		Double cost2 = o2.getPathCost();
		int result = cost1.compareTo(cost2);
		if (result == 0)
			return o1.getLabel().compareTo(o2.getLabel());
		else
			return result;
	}
}