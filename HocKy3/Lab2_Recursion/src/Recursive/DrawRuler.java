package Recursive;

public class DrawRuler {
	public static void drawRuler(int nInches, int majorLength) {
		drawLine(majorLength, 0);
		for (int i = 1; i <= nInches; i++) {
			drawInterval(majorLength - 1);
			drawLine(majorLength, i);
		}
	}

	public static void drawInterval(int centralLength) {
		if (centralLength >= 1) {
			drawInterval(centralLength - 1);
			drawLine(centralLength);
			drawInterval(centralLength - 1);
		}
	}

	public static void drawLine(int tick, int label) {
		for (int i = 0; i < tick; i++)
			System.out.print("-");
		if (label >= 0)
			System.out.print(" " + label);
		System.out.println("\n");
	}

	public static void drawLine(int tick) {
		drawLine(tick, -1);
	}

	public static void main(String[] args) {
		drawRuler(3, 3);
	}
}
