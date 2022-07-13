package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import puzzle.Node;
import puzzle.Puzzle;
import puzzle.PuzzleUtils;

public class GreedyBestFirstSearchPuzzle implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<Node>();
		frontier.add(model.getInitialState());
		if (model.computeH1(model.getInitialState()) % 2 == 0) {
			System.out.println("Initial State has inversion is even");
			return null;
		}
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.equals(model.getGoalState()))
				return currentNode;

			explored.add(currentNode);

			List<Node> nodes = model.getSuccessors(currentNode);
			for (Node node : nodes) {
				if (!frontier.contains(node) && !explored.contains(node)) {
					node.setG(currentNode.getG() + 1);
					frontier.add(node);
				}
			}
		}

		return null;
	}
}
