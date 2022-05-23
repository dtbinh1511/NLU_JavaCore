package electric_management;

import java.util.Date;

public class ThreeReading extends Reading {
	private int highIndex;
	private int lowIndex;

	public ThreeReading(int index, Date date, int highIndex, int lowIndex) {
		super(index, date);
		this.highIndex = highIndex;
		this.lowIndex = lowIndex;
	}

	public int getHighIndex() {
		return highIndex;
	}

	public int getLowIndex() {
		return lowIndex;
	}

}
