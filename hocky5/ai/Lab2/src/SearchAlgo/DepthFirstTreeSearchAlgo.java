package SearchAlgo;

import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class DepthFirstTreeSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node tree, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		frontier.push(tree);

		while (!frontier.isEmpty()) {
			Node currentNode = frontier.pop();
			if (currentNode.getLabel().equals(goal))
				return currentNode;

			List<Edge> edges = currentNode.getChildren();
			Collections.sort(edges);
			for (Edge edge : edges) {
				Node childNode = (Node) edge.getEnd().clone();
				childNode.setParent(currentNode);
				childNode.setPathCost(currentNode.getPathCost() + edge.getWeight());
				frontier.push(childNode);
			}
		}
		return null;
	}

	@Override
	public Node execute(Node tree, String start, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		frontier.push(tree);

		while (!frontier.isEmpty()) {
			Node currentNode = frontier.pop();
			if (currentNode.getLabel().equals(goal))
				return currentNode;
			if (currentNode.getLabel().equals(start)) {
				frontier.clear();
				currentNode.setParent(null);
				currentNode.setPathCost(0);
			}
			List<Edge> edges = currentNode.getChildren();
			Collections.sort(edges);
			for (Edge edge : edges) {
				Node childNode = (Node) edge.getEnd().clone();
				childNode.setParent(currentNode);
				childNode.setPathCost(currentNode.getPathCost() + edge.getWeight());
				frontier.push(childNode);
			}
		}
		return null;
	}

}
