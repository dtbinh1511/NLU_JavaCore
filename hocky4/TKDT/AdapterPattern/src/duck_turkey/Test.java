package duck_turkey;

public class Test {
	public static void main(String[] args) {
		Turkey wild = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(wild);
		Duck mallard = new MallardDuck();
		
		mallard.quack();
		mallard.fly();
		System.out.println("------------");
		turkeyAdapter.fly();
		turkeyAdapter.quack();
		
		
		System.out.println("------------");
		Turkey adapter = new DuckAdapter(mallard);
		adapter.gobble();
		adapter.fly();
	}
}
