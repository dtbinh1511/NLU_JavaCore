package strategypattern_simduck;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("No thing quack");
	}

}
