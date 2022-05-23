package Set_T.Du_Task2;

public class Even implements Predicate<Integer> {
	public boolean test(Integer i) {
		if (i % 2 == 0)
			return true;
		else
			return false;
	}

}
