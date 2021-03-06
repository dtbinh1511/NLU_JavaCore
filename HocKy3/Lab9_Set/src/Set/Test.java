package Set;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		int[][] a = new int[5][];
		for (int i = 0; i < a.length; i++)
			a[i] = new int[i];

		System.out.println(Arrays.deepToString(a));
	}

	public static int recur(int n) {
		if (n <= 10)
			return n * 2;
		return recur(recur(n / 3));
	}
}
