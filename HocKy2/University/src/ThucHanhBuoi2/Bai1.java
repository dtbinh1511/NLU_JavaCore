  package ThucHanhBuoi2;

public class Bai1 {
	public int[] arrayPlus(int[] arr1, int arr2[]) {
		// tạo độ dài của mảng 
		int[] arr = new int[arr1.length + arr2.length];
		// khởi tạo mảng mới 
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i >= arr1.length) {
				arr[i] = arr2[k];
				k++;
			} else {
				arr[i] = arr1[i];
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 5 };
		int arr2[] = { 9, 8, 7 };
		int arr[] = new Bai1().arrayPlus(arr1, arr2);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
