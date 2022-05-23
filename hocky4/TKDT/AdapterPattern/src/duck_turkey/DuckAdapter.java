package duck_turkey;

public class DuckAdapter implements Turkey {
	private Duck duck;

	public DuckAdapter(Duck duck) {
		super();
		this.duck = duck;
	}

	@Override
	public void gobble() {
		duck.quack();
	}

	@Override
	public void fly() {
		duck.fly();
	}

}
