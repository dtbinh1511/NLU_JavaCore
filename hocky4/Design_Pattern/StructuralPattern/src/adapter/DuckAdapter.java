package adapter;

public class DuckAdapter implements Turkey {
	Duck duck;

	public DuckAdapter(Duck duck) {
		super();
		this.duck = duck;
	}

	@Override
	public void gooble() {
		duck.quack();

	}

	@Override
	public void fly() {
		duck.fly();
	}

}
