package strategypattern_simduck;

public class FlyByRocketPower implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I am flying by rocket power");
	}

}
