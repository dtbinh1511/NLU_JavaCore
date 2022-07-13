package agent_XY;

import agent_XY.Environment.LocationStateXY;

public class EnvironmentState {
	private LocationStateXY[][] state; // trạng thái tại vị trí
	private XYLocation location; // row , col

	public EnvironmentState(int row, int col) {
		this.state = new LocationStateXY[row][col];
		initEnvironmentState();
	} 

	// init environment state such as the locations of dirts, the locations of wall
	private void initEnvironmentState() {
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[i].length; j++) {
				state[i][j] = Environment.LocationStateXY.CLEAN;
			}
		}

		int wall = (int) Math.ceil(state.length * 0.5);
		int dirty = (int) Math.ceil(state.length * 1);

		int count = 0;
		while (count < wall) {
			int row = (int) (Math.random() * state.length);
			int col = (int) (Math.random() * state.length);
			if (!state[row][col].equals(Environment.LocationStateXY.WALL) && row != 0 && col != 0) {
				state[row][col] = Environment.LocationStateXY.WALL;
				count++;
			}
		}

		count = 0;
		while (count < dirty) {
			int row = (int) (Math.random() * state.length);
			int col = (int) (Math.random() * state.length);
			if (!state[row][col].equals(Environment.LocationStateXY.DIRTY)
					&& !state[row][col].equals(Environment.LocationStateXY.WALL)) {
				state[row][col] = Environment.LocationStateXY.DIRTY;
				count++;
			}
		}
	}

	public int getRowState() {
		return state.length;
	}

	public int getColState() {
		return state[0].length;
	}

	public LocationStateXY getAgentState(XYLocation locationA) {
		return state[locationA.getRow()][locationA.getCol()];
	}

	public void setAgentState(XYLocation location, LocationStateXY state) {
		this.state[location.getRow()][location.getCol()] = state;
	}

	public XYLocation getAgentLocation() {
		return location;
	}

	public void setAgentLocation(XYLocation location) {
		this.location = location;
	}

	public void display() {

		System.out.println("Environment state: \n\t" + "[" + this.getAgentLocation().getRow() + ", "
				+ this.getAgentLocation().getCol() + "]" + ": " + this.getAgentState(location));

	}
}