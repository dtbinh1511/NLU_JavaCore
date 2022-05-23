package lab6_Arrays2D_T.Du;

public class Task2 {

	/*
	 * This method checks all rows and returns true if any of them are marked with
	 * all of a single player's markers. Otherwise, returns false.
	 */
	public static boolean checkRows(char[][] board) {
		int numCheck = 1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				if (board[i][j] == board[i][0] && board[i][0] != ' ')
					numCheck++;
			}
			if (numCheck >= 3)
				return true;
			else
				numCheck = 1;
		}
		return false;
	}

	/*
	 * This method checks all columns and returns true if any of them are marked
	 * with all of a single player's. Otherwise, returns false.
	 */
	public static boolean checkColumns(char[][] board) {
		int numCheck = 1;
		for (int j = 0; j < board[0].length; j++) {
			for (int i = 1; i < board.length; i++) {
				if (board[i][j] == board[0][j] && board[0][j] != ' ')
					numCheck++;
			}
			if (numCheck >= 3)
				return true;
			else
				numCheck = 1;
		}
		return false;
	}

	/*
	 * This method checks both diagonals and returns true if any of them are marked
	 * with all of a single player's markers. Otherwise, returns false.
	 */
	public static boolean checkDiagonals(char[][] board) {
		// Check top-left to bottom-right
		int numCheck = 1;
		for (int i = 1; i < board.length; i++) {
			if (board[i][i] == board[0][0] && board[0][0] != ' ')
				numCheck++;
		}
		if (numCheck >= 3)
			return true;

		// Check bottom-left to top-right

		numCheck = 0;
		int j = board.length - 1;
		for (int i = 0; i < board.length; i++) {
			if (board[i][j] == board[0][board.length - 1] && board[0][board.length-1] != ' ')
				numCheck++;
			j--;
		}
		if (numCheck >= 3)
			return true;
		return false;
	}

	public static void main(String[] args) {
		char[][] caro = { { 'x', 'x', 'x' }
						, { ' ', 'o', 'o' }
						, { 'o', ' ', 'o' } };

		System.out.println(checkRows(caro));
		System.out.println(checkColumns(caro));
		System.out.println(checkDiagonals(caro));
	}
}
