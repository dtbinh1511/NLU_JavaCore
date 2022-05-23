package electric_management;

import java.util.Date;

public abstract class Reading {
	protected int index;
	protected Date date;

	public Reading(int index, Date date) {
		super();
		this.index = index;
		this.date = date;
	}

	public int getIndex() {
		return index;
	}
}
