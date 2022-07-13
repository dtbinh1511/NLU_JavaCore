package GA;

public class Test {
	public static void main(String[] args) {
		
		GA_NQueenAlgo algo = new GA_NQueenAlgo();
		algo.initPopulation();
		Node res = algo.execute();
		
		res.displayBoard();
	}
}
