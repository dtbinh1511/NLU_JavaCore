package agent_AB; 

public class Percept {
	private String agentLocation; // vi tri dung
	private Environment.LocationState state; // trang thai

	public Percept(String agentLocation, Environment.LocationState state) {
		this.agentLocation = agentLocation;
		this.state = state;
	}

	public Environment.LocationState getLocationState() {
		return this.state;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}
}