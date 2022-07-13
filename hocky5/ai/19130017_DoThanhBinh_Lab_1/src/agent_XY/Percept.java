package agent_XY;

import agent_XY.Environment.LocationStateXY;

public class Percept {
	private XYLocation agentLocation; // trả về vị trí đứng
	private Environment.LocationStateXY state; // trả về trạng thái của vị trí đứng

	public Percept(XYLocation agentLocation, LocationStateXY state) {
		this.agentLocation = agentLocation;
		this.state = state;
	} 

	public Environment.LocationStateXY getLocationState() {
		return this.state;
	}

	public XYLocation getAgentLocation() {
		return this.agentLocation;
	}

}