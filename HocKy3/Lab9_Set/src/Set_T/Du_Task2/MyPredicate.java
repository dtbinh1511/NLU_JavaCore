package Set_T.Du_Task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicate {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		coll.remove(p);
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		coll.removeIf(p);
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {// TODO
		Set<T> res = new HashSet<>(coll);
		res.removeIf(p.negate());
		return res;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int index = 0;
		for (T t : coll) {
			if (p.test(t))
				return index;
			index++;
		}
		return -1;
	}

	public static void main(String[] args) {
		ArrayList<Integer> coll = new ArrayList<Integer>();
		coll.add(-2);
		coll.add(1);
		coll.add(3);
		coll.add(4);
		coll.add(5);
		coll.add(6);

		coll.removeIf(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return false;
			}

			
		});
//		retain(coll, p);
//		remove(coll, p);
		System.out.println(coll.toString());
	}
}
