package BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstGraphSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node tree, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> explored = new ArrayList<Node>();
		frontier.add(tree);

		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.getLabel().equals(goal))
				return currentNode;
			explored.add(currentNode);
			List<Edge> edges = currentNode.getChildren();
			for (Edge edge : edges) {
				Node childNode = edge.getEnd();
				if (!frontier.contains(childNode) && !explored.contains(childNode)) {
					childNode.setParent(currentNode);
					childNode.setPathCost(currentNode.getPathCost() + edge.getWeight());
					frontier.add(childNode);
				}
			}
		}
		return null;

	}

	@Override
	// find the path from start node to the goal node
	public Node execute(Node tree, String start, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> explored = new ArrayList<Node>();

		frontier.add(tree);
		while(!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			
			if(currentNode.getLabel().equals(goal))
				return currentNode;
			
			if(currentNode.getLabel().equals(start)) {
				frontier.clear();
				explored.clear();
				currentNode.setPathCost(0);
				currentNode.setParent(null);
			}
			
			explored.add(currentNode);
			List<Edge> edges = currentNode.getChildren();
			
			for (Edge edge : edges) {
				Node childNode = edge.getEnd();
				if(!frontier.contains(childNode)&&!explored.contains(childNode)) {
					childNode.setParent(currentNode);
					childNode.setPathCost(currentNode.getPathCost() + edge.getWeight());
					frontier.add(childNode);
				}
			}
		}

		return null;
	}

}
