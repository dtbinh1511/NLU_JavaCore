import java.util.Arrays;

public class RemoveDuplicate {
	public static int[] remove(int [] array) {
		int[] arrCp = new int[array.length];
		int count = 0;
		int i = 0;
		int k = 0;
		while (i < array.length) {
			arrCp[count++] = array[i];
			if (counter(arrCp, arrCp[i]) == 1) {
				arrCp[k++] = array[i];
			}
			i++;
		}
		return Arrays.copyOfRange(arrCp, 0, k);
	}
	public static int counter(int[] arr, int num) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num)
				count++;
		}
		return count;
	}
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 4, 7, 7, 8 };
		
		printArray(remove(arr));
	}
}
