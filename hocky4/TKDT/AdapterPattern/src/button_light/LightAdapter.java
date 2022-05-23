package button_light;

public class LightAdapter implements Switchable {
	private Light light;

	public LightAdapter(Light light) {
		super();
		this.light = light;
	}

	@Override
	public void turnOn() {
		light.on();
	}

	@Override
	public void turnOff() {
		light.off();
	}

}
