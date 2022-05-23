package lab4_sorting_T.Du;

import java.util.Arrays;
import java.util.Random;

public class Task1_2_Lab5 {

	// sort by ascending order
	public static int[] quickSort(int[] array) {
		if (array.length <= 1)
			return array;
		else {
			int numSelection = getPivot_First(array);
			
			int[] left = getArrayLeft(array, numSelection);
			int[] right = getArrayRight(array, numSelection);
			int[] mid = getArrayMid(array, numSelection);
			
			left = quickSort(left);
			right = quickSort(right);
			
			return concatenate(left, mid, right);
		}
	}

	//tim so phan tu nho hon so duoc chon
	private static int getAmountElementLessSelection(int[] array, int numberSelected) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < numberSelected)
				count++;
		}
		return count;
	}

	//tim so phan tu lon hon so duoc chon
	private static int getAmountElementMoreSelection(int[] array, int numberSelected) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > numberSelected)
				count++;
		}
		return count;
	}

	//tim so phan tu bang so duoc chon
	private static int getAmountElementEqualSelection(int[] array, int numberSelected) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numberSelected)
				count++;
		}
		return count;
	}

	//lay mang co cac phan tu nho hon so duoc chon
	private static int[] getArrayLeft(int[] array, int selection) {
		int[] leftArray = new int[getAmountElementLessSelection(array, selection)];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < selection) {
				leftArray[index] = array[i];
				index++;
			}
		}
		return leftArray;
	}

	//lay mang co cac phan tu lon hon so duoc chon
	private static int[] getArrayRight(int[] array, int selection) {
		int[] rightArray = new int[getAmountElementMoreSelection(array, selection)];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > selection) {
				rightArray[index] = array[i];
				index++;
			}
		}
		return rightArray;
	}

	//lay mang co cac phan tu bang so duoc chon
	private static int[] getArrayMid(int[] array, int selection) {
		int[] midArray = new int[getAmountElementEqualSelection(array, selection)];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == selection) {
				midArray[index] = array[i];
				index++;
			}
		}
		return midArray;
	}

	//ghep 3 mang lai
	private static int[] concatenate(int[] left, int[] mid, int[] right) {
		int[] resultArray = new int[left.length + mid.length + right.length];
		System.arraycopy(left, 0, resultArray, 0, left.length);
		System.arraycopy(mid, 0, resultArray, left.length, mid.length);
		System.arraycopy(right, 0, resultArray, resultArray.length - right.length, right.length);
		return resultArray;
	}

	// select pivot element based on the median of three
	// strategy
	private static int getPivot_MedianOfThree(int[] array) {
		int left = getPivot_First(array);
		int right = getPivot_Last(array);
		int mid = array[(array.length - 1) / 2];
		if ((left >= mid && left <= right) || (left <= mid && left >= right))
			return left;
		if ((right >= left && right <= mid) || ((right <= left && right >= mid)))
			return right;
		return mid;
	}

	// select pivot element based on the first element
	// in the array
	private static int getPivot_First(int[] array) {
		return array[0];
	}

	// select pivot element based on the last element in
	// the array
	private static int getPivot_Last(int[] array) {
		return array[array.length - 1];
	}

	// select pivot element based on choosing a randomly
	// element in
	// the array
	private static int getPivot_Random(int[] array) {
		return array[new Random().nextInt(array.length - 1)];
	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 2, 5, 12, 1, -2, 3, 14, 12 };
		
		array = quickSort(array);
		System.out.println(Arrays.toString(array));
	}
}
