package TicTacToe;


public class TicTacToe {

	public static boolean checkRows(char[][] board) {
		int check = 1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				if (board[i][j] == board[i][0] && board[i][0] != ' ')
					check++;
			}
			if (check == 3)
				return true;
			else
				check = 1;
		}
		return false;
	}

	public static boolean checkColumns(char[][] board) {
		int check = 1;
		for (int j = 0; j < board[0].length; j++) {
			for (int i = 1; i < board.length; i++) {
				if (board[i][j] == board[0][j] && board[0][j] != ' ')
					check++;
			}
			if (check == 3)
				return true;
			else
				check = 1;
		}
		return false;
	}

	public static boolean checkDiagonals(char[][] board) {
		int check = 1;
		for (int i = 1; i < board.length; i++) {
			if (board[i][i] == board[0][0] && board[0][0] != ' ')
				check++;
		}
		if (check == 3)
			return true;
		check = 1;
		int j = board[0].length - 2;
		for (int i = 1; i < board.length; i++) {
			if (board[i][j--] == board[0][board[0].length - 1] && board[0][board[0].length - 1] != ' ') {
				check++;
			}
		}
		if (check == 3)
			return true;

		return false;
	}

	
}
