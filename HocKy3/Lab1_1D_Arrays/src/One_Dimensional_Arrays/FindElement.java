package One_Dimensional_Arrays;

public class FindElement {
	/*
	 * Cho mảng A gồm n phần tử. Viết chương trình tìm số lớn thứ 2 trong mảng. Lưu
	 * ý chỉ được duyệt qua mảng 1 lần (1 vòng lặp)
	 */
	public static int find(int[] array) {
		int max = array[0] > array[1] ? array[0] : array[1];
		int result = array[0] < array[1] ? array[0] : array[1];
		for (int i = 2; i < array.length; i++) {
			if (array[i] > max) {
				result = max;
				max = array[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		System.out.println(find(array));
	}
}
