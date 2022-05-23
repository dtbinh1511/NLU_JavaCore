package adapter;

public class WillTurkey implements Turkey{

	@Override
	public void gooble() {
		System.out.println("Gooble, gooble");
		
	}

	@Override
	public void fly() {
		System.out.println("I'm flying a short distance");
	}

}
