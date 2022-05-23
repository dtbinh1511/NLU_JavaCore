package ThucHanhBuoi4;

public class Bai15 {

	public static void main(String[] args) {
		int[] arr1 = { 5, 2, 2, 2, 7, 1, 3 };
		int[] arr2 = { 1, 2, 7 };

		if (contain(arr1, arr2) == true) {
			System.out.println("Contain");
		} else {
			System.out.println("Not contain");
		}

	}

	public static boolean contain(int[] arr1, int[] arr2) {
		boolean check = false;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == arr2[0]) {
				int start = i;
				check = true;
				for (int j = 0; j < arr2.length; j++) {
					if (arr2[j] != arr1[start++]) {
						check = false;
						break;
					}
				}
				if (check == true) {
					return check;
				}
			}
		}
		return check;
	}
}