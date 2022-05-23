package strategy;

public class Squick implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Squick, Squick...");
	}
}
