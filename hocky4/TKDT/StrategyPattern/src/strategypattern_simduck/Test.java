package strategypattern_simduck;

public class Test {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		Duck rubber = new RubberDuck();
		Duck decoy = new DecoyDuck();

		mallard.display();
		mallard.swim();
		mallard.performQuack();
		mallard.performFly();

		System.out.println("--------------");
		rubber.display();
		rubber.swim();
		rubber.performQuack();
		rubber.performFly();

		System.out.println("--------------");
		decoy.setFlyBehavior(new FlyByRocketPower());
		decoy.display();
		decoy.swim();
		decoy.performQuack();
		decoy.performFly();
	}
}
