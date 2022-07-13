package inform;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGn());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal))
				return current;

			explored.add(current);
			List<Edge> edges = current.getChildren();
			for (Edge edge : edges) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(current);
					//child.setG(edge.getWeight() + current.getG()); co thi cap nhat (khong bat buoc)
					frontier.add(child);
				}
			}
		}

		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGn());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			
			if (current.getLabel().equals(start)) {
				current.setParent(null);
				frontier.clear();
				explored.clear();
			}

			if (current.getLabel().equals(goal) && explored.contains(new Node(start)))
				return current;

			explored.add(current);
			List<Edge> edges = current.getChildren();
			for (Edge edge : edges) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(current);
					frontier.add(child);
				}
			}
		}
		return null;
	}

	class NodeComparatorByGn implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			Double h1 = o1.getH();
			Double h2 = o2.getH();
			int result = h1.compareTo(h2);
			if (result == 0)
				return o1.getLabel().compareTo(o2.getLabel());
			else
				return result;
		}
	}
}
