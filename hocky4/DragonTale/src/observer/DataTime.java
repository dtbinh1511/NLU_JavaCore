
package observer;

import java.util.Date;
import java.util.Observable;

public class DataTime extends Observable {
	private String h;
	private String m;
	private String s;

	public void DataTime() {
	}

	public void setTime() {
		Date date = new Date();
		this.h = String.valueOf(date.getHours()).length() == 2 ? date.getHours() + "" : "0" + date.getHours();
		this.m = String.valueOf(date.getMinutes()).length() == 2 ? date.getMinutes() + "" : "0" + date.getMinutes();
		this.s = String.valueOf(date.getSeconds()).length() == 2 ? date.getSeconds() + "" : "0" + date.getSeconds();

		setChanged();
		notifyObservers();
	}
	// getter - setter

	public String getH() {
		return h;
	}

	public void setH(String h) {
		this.h = h;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
