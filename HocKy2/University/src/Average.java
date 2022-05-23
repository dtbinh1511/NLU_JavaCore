import java.util.Random;

public class Average {

	public static void main(String[] args) {
		// Create array
		int[] array = new int[10];
		averageArray(array);
	}

	public static void averageArray(int[] array) {
		// Create random
		Random random = new Random();
		// Create function
		int sum = 0;
		// Create element in random array
		for (int i = 0; i < 10; i++) {
			// Limit random number
			array[i] = random.nextInt(100);
			// Input element random
			System.out.print(array[i] + ", ");
			// Calculator sum
			sum += array[i];

		}
		// Create function average
		double avg = (double) sum / array.length;
		// Input
		System.out.println("Average of array is = " + avg);
	}

}
