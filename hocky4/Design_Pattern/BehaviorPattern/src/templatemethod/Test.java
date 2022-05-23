package templatemethod;

public class Test {
	public static void main(String[] args) {
		CaffeineBeverageWithHook caffee = new Caffee();
		CaffeineBeverageWithHook tea = new Tea();
		
		caffee.prepareRecipe();
		tea.prepareRecipe();
	}
}
