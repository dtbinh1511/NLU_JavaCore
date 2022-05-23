package button_light;

public class Button {
	Switchable switchable;

	public Button(Switchable switchable) {
		super();
		this.switchable = switchable;
	}

	public void press() {
		switchable.turnOn();
	}

	public void turnOff() {
		switchable.turnOff();
	}
}
