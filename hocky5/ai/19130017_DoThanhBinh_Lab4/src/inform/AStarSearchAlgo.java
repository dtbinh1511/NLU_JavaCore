package inform;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByAStar());
		List<Node> explored = new ArrayList<Node>();
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
					child.setG(edge.getWeight() + current.getG());
					frontier.add(child);
				} else if (frontier.contains(child)) {
					double newG = current.getG() + edge.getWeight();
					if (child.getG() > newG) {
						child.setG(newG);
						child.setParent(current);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByAStar());
		List<Node> explored = new ArrayList<Node>();
		frontier.add(root);

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start)) {
				frontier.clear();
				explored.clear();
				current.setParent(null);
				current.setG(0);
			}
			if (current.getLabel().equals(goal) && explored.contains(new Node(start)))
				return current;

			explored.add(current);
			List<Edge> edges = current.getChildren();
			for (Edge edge : edges) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setG(edge.getWeight() + current.getG());
					child.setParent(current);
					frontier.add(child);
				} else if (frontier.contains(child)) {
					double newG = current.getG() + edge.getWeight();
					if (child.getG() > newG) {
						child.setG(newG);
						child.setParent(current);
					}
				}
			}
		}
		return null;
	}

	public boolean isAdmissibleH(Node tree, String goal) {
		List<Node> list = getListNode(tree);
		for (Node node : list) {
			Node goalNode = execute(tree, node.getLabel(), goal);
			if (goalNode != null && node.getH() > goalNode.getG())
				return false;
		}

		return true;
	}

	public List<Node> getListNode(Node tree) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByAStar());
		frontier.add(tree);

		List<Node> list = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			list.add(current);
			List<Edge> edges = current.getChildren();
			for (Edge edge : edges) {
				Node child = edge.getEnd();
				if (!list.contains(child) && !frontier.contains(child)) {
					child.setParent(current);
					frontier.add(child);
				}
			}
		}

		return list;
	}

	class NodeComparatorByAStar implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			Double h1 = o1.getH();
			Double h2 = o2.getH();

			Double g1 = o1.getG();
			Double g2 = o2.getG();

			Double f1 = h1 + g1;
			Double f2 = h2 + g2;

			int result = f1.compareTo(f2);
			if (result == 0)
				return o1.getLabel().compareTo(o2.getLabel());
			else
				return result;
		}
	}

}
