package main;

import observer.DataTime;
import view.GamePlay;

public class Test {
	public static void main(String[] args) {
		DataTime data = new DataTime();

		GamePlay game = new GamePlay(data);
		while (true) {
			data.setTime();
		}
	}

}
