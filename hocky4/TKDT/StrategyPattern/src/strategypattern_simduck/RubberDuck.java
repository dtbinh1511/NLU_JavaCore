package strategypattern_simduck;

public class RubberDuck extends Duck {
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squick();
	}

	@Override
	public void display() {
		System.out.println("I am a rubber duck");
	}

}
