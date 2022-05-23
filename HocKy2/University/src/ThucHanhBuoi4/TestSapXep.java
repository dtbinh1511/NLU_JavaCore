package ThucHanhBuoi4;

public class TestSapXep {
	public static void giamDan(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + i];
					a[i + 1] = temp;
				}
			}
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		int array[] = { 10, 2, 4, 7, 9 };
		giamDan(array);
	}

}
