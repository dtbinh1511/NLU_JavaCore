package queen;

public class HillClimbingAlgo {
	private int stepClimbed = 0;
	private int stepClimbedAfterRandomRestart = 0;
	private int randomRestarts = 0;

	public Node execute(Node initialState) {
		Node current = initialState;
		while (current.getH() != 0) {
			Node neighbor = current.getBestCandidate();
			if (neighbor.getH() > current.getH()) {
				current = neighbor;
			}
			stepClimbedAfterRandomRestart++;
			stepClimbed++;
			return current;
		}
		return null;
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		Node state = execute(initialState);
		while (state.getH() != 0) {
			randomRestarts++;
			stepClimbedAfterRandomRestart++;
			state.generateBoard();
			state = new Node(state);
		}
		System.out.println("randomRestarts: " + randomRestarts);
		System.out.println("stepClimbedAfterRandomRestart: " + stepClimbedAfterRandomRestart);
		System.out.println("stepClimbed: " + stepClimbed);
		return state;
	}
}
