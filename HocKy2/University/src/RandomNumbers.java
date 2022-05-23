
public class RandomNumbers {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		int[] brray = new int[array.length];
		numberRandom(array, brray);
	}
  
	public static void numberRandom(int[] array, int[] brray) {
		for (int i = 0; i < brray.length; i++) {
			brray[i] = 0;
		}

		int randomNum = 0;
		for (int i = 0; i < brray.length; i++) {
			randomNum = (int) (Math.random() * array.length);
			if (brray[randomNum] == 1) {
				i = i - 1;
			} else {
				System.out.print(array[randomNum] + " ");
			}
			for (int j = 0; j < brray.length; j++) {
				if (array[randomNum] == array[j]) {
					brray[j] = 1;
					break;
				}
			}
		}
	}
}
