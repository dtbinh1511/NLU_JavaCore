package AlphaBeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaLeftToRightSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("values:" + v);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if (node.isTerminal())
			return node.getValue();
		else {
			int v = Integer.MIN_VALUE;
			List<Node> successors = node.getChildren();
			List<Node> explored = new ArrayList<Node>();
			explored.addAll(successors);
			for (Node s : successors) {
				explored.remove(s);
				v = Math.max(v, minValue(s, alpha, beta));
				if (v >= beta) {
					for (Node e : explored) {
						System.out.print("node cut: ");
						print(e);
					}
					return v;
				}
				alpha = Math.max(alpha, v);
			}
			System.out.println("Best move node: " + node.getLabel() + " is " + v);
			return v;
		}
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		if (node.isTerminal())
			return node.getValue();
		else {
			int v = Integer.MAX_VALUE;
			List<Node> successors = node.getChildren();

			List<Node> explored = new ArrayList<Node>();
			explored.addAll(successors);

			for (Node s : successors) {
				explored.remove(s);
				v = Math.min(v, maxValue(s, alpha, beta));
				if (v <= alpha) {
					// in c???t
					for (Node e : explored) {
						System.out.print("node cut: ");
						print(e);
					}
					return v;
				}
				beta = Math.min(beta, v);
			}
			System.out.println("Best move node: " + node.getLabel() + " is " + v);
			return v;
		}
	}

	public void print(Node node) {
		if (node.isTerminal()) {
			System.out.println(node.getLabel() + ":" + node.getValue());
		} else {
			System.out.println(node.getLabel());
			for (Node child : node.getChildren()) {
				if (child.isTerminal()) {
					System.out.println(child.getLabel() + ":" + child.getValue());
					continue;
				}
				print(child);
			}
		}
	}
}
