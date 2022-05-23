import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
//		HashMap<String, Integer> m = new HashMap<>();
//		m.put("I", 3);
//		m.put("will", 5);
//		m.put("pass", 7);
//		m.put("pass", 10);
//		System.out.println(m);
	
//		ListIterator<Integer> iter = list.listIterator();
//		System.out.println(get(2, iter));
//		Stack s = new Stack<>();
//		s.push(10);
//		s.push(11);
//		s.push(12);
//		s.pop();
//		s.peek();
//		s.peek();
//		s.pop();
//
//		System.out.println(s);
		
	}

	public static ArrayList<Integer> list(Iterator<Integer> iter) {
		ArrayList<Integer> res = new ArrayList<>();
		while (iter.hasNext()) {
			if (iter.next() % 2 == 0) {
				res.add(iter.next());
			}
		}
		return res;
	}

	public static int get(int i, ListIterator<Integer> list) {
		int res = 0;
		while (list.hasNext()) {
			if (list.next() == i) {
				list.previous();
				res = list.previous();
				break;
			}
		}
		return res;
	}
}
