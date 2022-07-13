package queen;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		if (row < Node.N - 1)
			row++;
		else
			row = 0;
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		// check col and row
		if (column == q.getColumn() || row == q.getRow())
			return true;
		// check diagonal
		if (Math.abs(column - q.getColumn()) == Math.abs(row - q.getRow()))
			return true;
		return false;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
