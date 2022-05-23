package templatemethod;

import java.util.Scanner;

public class Caffee extends CaffeineBeverageWithHook {

	@Override
	protected void addCondiments() {
		System.out.println("Adding sugar and Milk");
	}

	@Override
	protected void brew() {
		System.out.println("Dripping coffee through filter");
	}

	@Override
	public boolean customerWantsCondiments() {
		String answer = getInputUser();
		if (answer.toLowerCase().startsWith("y"))
			return true;
		return false;
	}

	private String getInputUser() {
		System.out.println("Would you like milk and sugar (y/n)?");
		Scanner sc = new Scanner(System.in);
		String answer = sc.nextLine();
		if (answer == null)
			return "no";
		return answer;
	}

}
