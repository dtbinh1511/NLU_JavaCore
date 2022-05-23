package ThucHanhBuoi4;

public class Bai17_way2 {
	public static int[] divitionBy5(int number) {
		int array[] = new int[5];
		int count = 0;
		while (count <= number) {
			array[count % 5]++;
			count++;
		}
		return array;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println("Số chia hết cho 5 dư " + i + " là " + divitionBy5(100)[i]);

		}
	}
}
