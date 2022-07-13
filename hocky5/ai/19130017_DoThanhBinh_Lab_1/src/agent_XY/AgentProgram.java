package agent_XY;

public class AgentProgram {
	public Action execute(Percept p) {// location, status
		// TODO

		if (p.getLocationState().equals(Environment.LocationStateXY.DIRTY))
			return Environment.SUCK_DIRT;
		if (p.getLocationState().equals(Environment.LocationStateXY.CLEAN)) {
			int ran = (int) (Math.random() * 4);
			switch (ran) {
			case 0:
				return Environment.MOVE_LEFT;
			case 1:
				return Environment.MOVE_RIGHT;
			case 2:
				return Environment.MOVE_DOWN;
			case 3:
				return Environment.MOVE_UP;
			}
		}
		return NoOpAction.NO_OP;
	}
}