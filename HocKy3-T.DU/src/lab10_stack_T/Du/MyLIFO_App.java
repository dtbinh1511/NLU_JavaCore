package lab10_stack_T.Du;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {
	// method stutter that accepts a queue of
	// integers as a parameter and replaces
	// every element of the queue with two copies of
	// that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		Queue<E> es = new LinkedList<E>();
		while (!input.isEmpty()) {
			es.add(input.remove());
		}
		while (!es.isEmpty()) {
			E e = es.remove();
			input.add(e);
			input.add(e);
		}
	}

	// Method mirror that accepts a queue of strings
	// as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Stack<E> stack = new Stack<>();
		for (E e : input) {
			stack.add(e);
		}
		while(!stack.isEmpty()) {
			input.add(stack.pop());
		}
	}

	public static void main(String[] args) {
		Queue<Integer> input = new LinkedList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(5);
		stutter(input);
		System.out.println(input);
		mirror(input);
		System.out.println(input);
	}

}
