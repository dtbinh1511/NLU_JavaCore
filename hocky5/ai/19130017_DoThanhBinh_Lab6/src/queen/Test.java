package queen;

public class Test {
	public static void main(String[] args) {
		Node initialState = new Node();

		HillClimbingAlgo algo = new HillClimbingAlgo();
		Node res = algo.executeHillClimbingWithRandomRestart(initialState);
		System.out.println("Hill climbing:");
		res.displayBoard();

		SAAlgo_NQueen sAAlgo = new SAAlgo_NQueen();
		Node result = sAAlgo.execute(initialState);
		System.out.println("SA:");
		result.displayBoard();
	}
}
