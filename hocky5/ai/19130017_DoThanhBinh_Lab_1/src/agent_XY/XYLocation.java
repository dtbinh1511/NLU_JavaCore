package agent_XY;

public class XYLocation {
	public int row;
	public int col;

	public XYLocation(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setAll(int col, int row) {
		this.row = row;
		this.col = col;
	}
}
