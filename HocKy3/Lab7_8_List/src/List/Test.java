package List;

import java.util.Arrays;
import java.util.ListIterator;

public class Test {
	public static void main(String[] args) {
		Integer[] arr = { 1, 3, 5, 7, 9 };

		ListIterator<Integer> li = Arrays.asList(arr).listIterator();
		while (li.hasNext()) {
			Object element = li.next();
			System.out.println(element);
		}

	}
}
