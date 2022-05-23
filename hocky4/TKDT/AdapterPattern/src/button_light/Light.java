package button_light;

public class Light {
	private boolean on;

	public void on() {
		System.out.println("Turn on");
		on = true;
	}

	public void off() {
		System.out.println("Turn off");
		on = false;
	}

	public boolean isOn() {
		return on;
	}

}
