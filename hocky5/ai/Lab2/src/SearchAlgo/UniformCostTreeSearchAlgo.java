package SearchAlgo;

import java.util.List;
import java.util.PriorityQueue;


public class UniformCostTreeSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node tree, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(tree);

		while (!frontier.isEmpty()) {
			Node node = frontier.poll();

			if (node.getLabel().equals(goal))
				return node;

			List<Edge> edges = node.getChildren();

			for (Edge edge : edges) {
				Node child = (Node) edge.getEnd().clone();
				child.setParent(node);
				child.setPathCost(node.getPathCost() + edge.getWeight());
				frontier.add(child);
			}
		}
		return null;
	}

	@Override
	public Node execute(Node tree, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(tree);

		while (!frontier.isEmpty()) {
			Node node = frontier.poll();
			if (node.getLabel().equals(start)) {
				node.setParent(null);
				node.setPathCost(0);
				frontier.clear();
			}

			if (node.getLabel().equals(goal) )
				return node;

			List<Edge> edges = node.getChildren();
			for (Edge edge : edges) {
				Node child = (Node) edge.getEnd().clone();
				child.setParent(node);
				child.setPathCost(node.getPathCost() + edge.getWeight());
				frontier.add(child);

			}
		}

		return null;
	}

}
