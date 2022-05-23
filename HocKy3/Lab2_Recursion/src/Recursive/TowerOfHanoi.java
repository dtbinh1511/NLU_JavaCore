package Recursive;

public class TowerOfHanoi {
	public static void moveTower(int disk, int src, int des, int spare) {
		if (disk == 1)
			System.out.println("Move disk " + disk + " from " + src + " to " + des);
		else {
			moveTower(disk - 1, src, spare, des);
			System.out.println("Move disk " + disk + " from " + src + " to "  + des);
			moveTower(disk - 1, spare, des, src);
		}
	}

	public static void main(String[] args) {
		moveTower(3, 1, 3, 2);
	}
}
