package SearchAlgo;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstTreeSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node tree, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(tree);

		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal))
				return currentNode;

			List<Edge> edges = currentNode.getChildren();
			for (Edge edge : edges) {
				Node childNode = (Node) edge.getEnd().clone();
				childNode.setParent(currentNode);
				childNode.setPathCost(currentNode.getPathCost() + edge.getWeight());
				frontier.add(childNode);
			}
		}
		return null;
	}

	@Override
	public Node execute(Node tree, String start, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(tree);

		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal))
				return currentNode;

			if (currentNode.getLabel().equals(start)) {
				frontier.clear();
				currentNode.setParent(null);
				currentNode.setPathCost(0);
			}

			List<Edge> edges = currentNode.getChildren();
			for (Edge edge : edges) {
				Node childNode = (Node) edge.getEnd().clone();
				childNode.setParent(currentNode);
				childNode.setPathCost(currentNode.getPathCost() + edge.getWeight());
				frontier.add(childNode);
			}
		}
		return null;
	}

}
