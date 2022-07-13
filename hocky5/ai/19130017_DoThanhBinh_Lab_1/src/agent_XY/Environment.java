package agent_XY;

import java.util.Iterator;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");

	public enum LocationStateXY {
		CLEAN, DIRTY, WALL
	}

	private EnvironmentState envState;
	private Agent agent = null;
	private int count = 0;
	private int dirtyNum = 0;
	private int score = 0;

	public Environment(int row, int col) {
		envState = new EnvironmentState(row, col);
		dirtyNum = (int) Math.ceil(row * 1);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, XYLocation location) {
		this.agent = agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		// TODO
		XYLocation locationCurrent = envState.getAgentLocation();
		int row = locationCurrent.getRow();
		int col = locationCurrent.getCol();

		if (action == Environment.MOVE_DOWN && row != envState.getRowState() - 1
				&& !(envState.getAgentState(new XYLocation(row + 1, col)).equals(Environment.LocationStateXY.WALL))) {
			envState.setAgentLocation(new XYLocation(row + 1, col));
			score -= 10;
		} else if (action == Environment.MOVE_UP && row != 0
				&& !(envState.getAgentState(new XYLocation(row - 1, col)).equals(Environment.LocationStateXY.WALL))) {
			envState.setAgentLocation(new XYLocation(row - 1, col));
			score -= 10;
		} else if (action == Environment.MOVE_LEFT && col != 0
				&& !(envState.getAgentState(new XYLocation(row, col - 1)).equals(Environment.LocationStateXY.WALL))) {
			envState.setAgentLocation(new XYLocation(row, col - 1));
			score -= 10;
		} else if (action == Environment.MOVE_RIGHT && col != envState.getColState() - 1
				&& !(envState.getAgentState(new XYLocation(row, col + 1)).equals(Environment.LocationStateXY.WALL))) {
			envState.setAgentLocation(new XYLocation(row, col + 1));
			score -= 10;
		}
		if (action == Environment.SUCK_DIRT) {
			envState.setAgentState(locationCurrent, LocationStateXY.CLEAN);
			score += 500;
			count++;
		}
		return envState;

	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		// TODO
		Percept p = new Percept(envState.getAgentLocation(), envState.getAgentState(envState.getAgentLocation()));
		return p;
	}

	public void step() {
		envState.display();
		XYLocation agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + "[" + agentLocation.getRow() + "," + agentLocation.getCol() + "]"
				+ "\tAction: " + anAction);
		System.out.println("Score = " + this.score);
		es.display();

	}

	public boolean checkClean() {
		if (count == dirtyNum) {
			return true;
		}
		return false;
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;
		while (checkClean() == false) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
