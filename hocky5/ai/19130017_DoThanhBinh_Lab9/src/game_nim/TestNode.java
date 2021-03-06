package game_nim;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 3, 3, 1 };
		node.addAll(Arrays.asList(data));

		System.out.println("Children: " + node.getSuccessors());

		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);
	}
}