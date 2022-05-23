package beverage_with_hook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaWithHooks extends CoffeinBeverageWithHooks {

	@Override
	public void brew() {
		System.out.println("Stepping the tea");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding Lemon");
	}

	public boolean customerWantsCondiments() {
		String answer = getUserInput();
		if (answer.toLowerCase().startsWith("y"))
			return true;
		return false;

	}

	private String getUserInput() {
		String answer = null;

		System.out.println("Would you like lemon (y/n)?");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = reader.readLine();
		} catch (IOException e) {
			System.out.println("IO error");
		}

		if (answer == null)
			return "no";
		return answer;
	}
}
