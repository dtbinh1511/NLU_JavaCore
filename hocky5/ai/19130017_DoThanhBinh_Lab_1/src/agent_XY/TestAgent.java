package agent_XY;

public class TestAgent {
	public static void main(String[] args) {
		Environment env = new Environment(4, 5);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, new XYLocation(0, 0));

		env.stepUntilDone();

	}

}
