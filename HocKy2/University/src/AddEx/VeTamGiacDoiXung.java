package AddEx;

public class VeTamGiacDoiXung {
	public static void draw(int height) {
		for (int i = 1; i <= height; i++) {
			for (int j = i; j <= height; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j < i + 1; j++) {
				System.out.print(j + " ");
			}
			for (int j = i-1; j > 0; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int height = 9;
		draw(height);
	}
}
