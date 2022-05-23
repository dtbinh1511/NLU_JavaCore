package lab8_set_T.Du;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		coll.removeIf(p);
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		coll.removeIf(p.negate());
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> set = new HashSet<T>(coll);
		set.removeIf(p.negate());
		return set;
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
		Predicate<Integer> p = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t > 0;
			}
		};
//		remove(coll, p);
////		retain(coll, p);
//		
//		for (Integer integer : coll) {
//			System.out.println(integer);
//		}
//		Set<Integer> integers = collect(coll, p);
//		for (Integer integer : integers) {
//			System.out.println(integer);
//		}
		System.out.println(find(coll, p));
	}
}
