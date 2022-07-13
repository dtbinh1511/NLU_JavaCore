package BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstGraphSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node tree, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		List<Node> explored = new ArrayList<Node>();
		frontier.push(tree);

		while (!frontier.empty()) {
			Node currentNode = frontier.pop();
			if (currentNode.getLabel().equals(goal)) {
				return currentNode;
			}
			explored.add(currentNode);
			List<Edge> edges = currentNode.getChildren();
			Collections.sort(edges);
			for (Edge edge : edges) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setPathCost(currentNode.getPathCost() + edge.getWeight());
					child.setParent(currentNode);
					frontier.push(child);
				}
			}
		}

		return null;
	}

	@Override
	public Node execute(Node tree, String start, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		List<Node> explored = new ArrayList<Node>();
		frontier.push(tree);
		Node startNode = new Node(start);
		
		while (!frontier.empty()) {
			Node currentNode = frontier.pop();
			
			if (currentNode.getLabel().equals(start)) {
				frontier.clear();
				explored.clear();
				currentNode.setParent(null);
				currentNode.setPathCost(0);
			}
			
			if (currentNode.getLabel().equals(goal) && explored.contains(startNode)) {
				return currentNode;
			}

			explored.add(currentNode);
			List<Edge> edges = currentNode.getChildren();
			
			Collections.sort(edges);
			
			for (Edge edge : edges) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setPathCost(currentNode.getPathCost() + edge.getWeight());
					child.setParent(currentNode);
					frontier.push(child);
				}
			}
		}
		return null;
	}

}
