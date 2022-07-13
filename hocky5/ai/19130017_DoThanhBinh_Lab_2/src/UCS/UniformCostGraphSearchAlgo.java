package UCS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import BFS_DFS.Edge;
import BFS_DFS.ISearchAlgo;
import BFS_DFS.Node;

public class UniformCostGraphSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node tree, String goal) {

		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explored = new ArrayList<Node>();
		frontier.add(tree);

		while (!frontier.isEmpty()) {
			Node node = frontier.poll();

			if (node.getLabel().equals(goal))
				return node;

			explored.add(node);
			List<Edge> edges = node.getChildren();

			for (Edge edge : edges) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(node);
					child.setPathCost(node.getPathCost() + edge.getWeight());
					frontier.add(child);
				} else if (frontier.contains(child)) {
					double newPathCost = node.getPathCost() + edge.getWeight();
					if (child.getPathCost() > newPathCost) {
						child.setPathCost(newPathCost);
						child.setParent(node);
					}

				}
			}
		}

		return null;

	}

	@Override
	public Node execute(Node tree, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explored = new ArrayList<Node>();

		Node startNode = new Node(start);
		frontier.add(tree);

		while (!frontier.isEmpty()) {
			Node node = frontier.poll();

			if (node.getLabel().equals(start)) {
				node.setParent(null);
				node.setPathCost(0);
				frontier.clear();
				explored.clear();
			}

			if (node.getLabel().equals(goal) && explored.contains(startNode))
				return node;

			explored.add(node);

			List<Edge> edges = node.getChildren();
			for (Edge edge : edges) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(node);
					child.setPathCost(node.getPathCost() + edge.getWeight());
					frontier.add(child);
				} else if (frontier.contains(child)) {
					double newPathCost = node.getPathCost() + edge.getWeight();
					if (child.getPathCost() > newPathCost) {
						child.setPathCost(newPathCost);
						child.setParent(node);
					}
				}

			}
		}

		return null;
	}

	class NodeComparator implements Comparator<Node> {

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
}
