package templatemethod;

public class Tea extends CaffeineBeverageWithHook{

	@Override
	protected void brew() {
	System.out.println("Steeping the tea");		
	}

	@Override
	protected void addCondiments() {
		System.out.println("Adding lemon");
	}

}
