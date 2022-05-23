package strategypattern_simduck;

public class Squick implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Squick, squick,...");
	}

}
