package calculation;

public class Client {
	private Strategy strategy;

	public Client(Strategy strategy) {
		super();
		this.strategy = strategy;
	}

	public float calculate(float a, float b) {
		return strategy.calculate(a, b);
	}
}
