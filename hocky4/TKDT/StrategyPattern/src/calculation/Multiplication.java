package calculation;

public class Multiplication implements Strategy {

	@Override
	public float calculate(float a, float b) {
		return a * b;
	}

}
