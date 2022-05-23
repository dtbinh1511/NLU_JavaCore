package lab2_T.Du;

public class TowerOfHaNoi {
	public static void moveTower(int src, int dest, int spare, int disk) {
		if (disk == 1)
			System.out.println(src + " --> " + spare);
		else {
			moveTower(src, spare, dest, 1);
			moveTower(src, dest, spare, disk - 1);
			moveTower(dest, src, spare, 1);
		}
	}

	public static void main(String[] args) {
		moveTower(1, 2, 3, 3);
	}
}
