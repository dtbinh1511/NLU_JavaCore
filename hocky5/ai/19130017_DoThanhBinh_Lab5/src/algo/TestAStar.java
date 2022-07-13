package algo;

import puzzle.Node;
import puzzle.Puzzle;

public class TestAStar {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("txt/PuzzleMap.txt", "txt/PuzzleGoalState.txt");

		long st = System.currentTimeMillis();
		IPuzzleAlgo algo = new AStarPuzzleAlgo();
		Node res = algo.execute(p);
		long et = System.currentTimeMillis();
		System.out.println(res + "\n Runtime: " + (et - st) + "ms");
	}

}
