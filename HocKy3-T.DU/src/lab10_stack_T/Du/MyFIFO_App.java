package lab10_stack_T.Du;

import java.util.Arrays;
import java.util.Stack;

public class MyFIFO_App {

	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> stack = new Stack<>();
		for (int i = 0; i < array.length; i++) {
			stack.push(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = stack.pop();
		}
	}

	// This method checks the correctness of the
	// given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==>
	// false
	// {[()]}

	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		char[] chars = input.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{')
				stack.push(chars[i]);
			else if (chars[i] == ')' || chars[i] == ']' || chars[i] == '}') {

				if (stack.isEmpty())
					return false;

				switch (chars[i]) {
				case ')':
					if (stack.pop() != '(')
						return false;
					break;
				case ']':
					if (stack.pop() != '[')
						return false;
					break;
				case '}':
					if (stack.pop() != '{')
						return false;
					break;
				default:
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	// This method evaluates the value of expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		char[] chars = expression.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i > 0 && isNumber(chars[i]) && isNumber(chars[i - 1]))
				stack1.set(stack1.size() - 1, stack1.peek() * 10 + parse(chars[i]));
			else if (isNumber(chars[i]))
				stack1.push(parse(chars[i]));
			if (isOprator(chars[i]))
				stack2.push(chars[i]);
			if (isOpenParentheses(chars[i]))
				stack2.push(chars[i]);
			if (isCloseParentheses(chars[i])) {
				switch (stack2.pop()) {
				case '+':
					stack1.set(stack1.size() - 2, stack1.get(stack1.size() - 2) + stack1.pop());
					stack2.pop();
					break;
				case '-':
					stack1.set(stack1.size() - 2, stack1.get(stack1.size() - 2) - stack1.pop());
					stack2.pop();
					break;
				case '*':
					stack1.set(stack1.size() - 2, stack1.get(stack1.size() - 2) * stack1.pop());
					stack2.pop();
					break;
				case '/':
					stack1.set(stack1.size() - 2, stack1.get(stack1.size() - 2) / stack1.pop());
					stack2.pop();
					break;
				}
			}
		}
		for (Character character : stack2) {
			switch (character) {
			case '+':
				stack1.set(0, stack1.get(0) + stack1.get(0 + 1));
				stack1.remove(1);
				break;
			case '-':
				stack1.set(0, stack1.get(0) - stack1.get(0 + 1));
				stack1.remove(1);
				break;
			case '*':
				stack1.set(0, stack1.get(0) * stack1.get(0 + 1));
				stack1.remove(1);
				break;
			case '/':
				stack1.set(0, stack1.get(0) / stack1.get(0 + 1));
				stack1.remove(1);
				break;
			}
		}
		return stack1.pop();
	}

	public static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	public static int parse(char c) {
		return Integer.parseInt(String.valueOf(c));
	}

	public static boolean isOprator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	public static boolean isOpenParentheses(char c) {
		return c == '(' || c == '[' || c == '{';
	}

	public static boolean isCloseParentheses(char c) {
		return c == ')' || c == ']' || c == '}';
	}

	// This method checks the well-defined of a given
	// HTML or
	// XML file

	public static boolean isWell_Defined(String fileName) {
		if (!checkDot(fileName))
			return false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < fileName.length(); i++) {
			stack.push(fileName.charAt(i));
		}
		
		StringBuilder s = new StringBuilder();
		while (stack.peek() != '.') {
			s.append(stack.pop());
		}
		return String.valueOf(s).equals("lmth") || String.valueOf(s).equals("lmx");
	}
	
	public static boolean checkDot(String fileName) {
		for (int i =0; i < fileName.length(); i++) {
			if (fileName.charAt(i) == '.')
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
//		Integer[] arr = { 1, 2, 3, 4, 5, 6 };
//		reserve(arr);
//		System.out.println(Arrays.toString(arr));
//		String input = "}()(())[]{(())}";
//		System.out.println(isCorrect(input));
//		String s = "51 + (54 *(3+2)) + 56";
//		System.out.println(evaluateExpression(s));
//		
		String fileName = "asd.xml";
		System.out.println(isWell_Defined(fileName));
	}
}
