package calculation;

public class Addition implements Strategy {

	@Override
	public float calculate(float a, float b) {
		return a + b;
	}

}
