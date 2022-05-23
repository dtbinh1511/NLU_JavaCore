package adapter;

public class TestDrive {
	public static void main(String[] args) {
		Turkey willTurkey = new WillTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(willTurkey);
		Duck mallarduck = new MallardDuck();
		turkeyAdapter.quack();
		turkeyAdapter.fly();
		mallarduck.quack();
		mallarduck.fly();
		System.out.println("-----");
		Turkey duckAdapter = new DuckAdapter(mallarduck);
		duckAdapter.gooble();
		duckAdapter.fly();
		willTurkey.gooble();
		willTurkey.fly();
	}
}
