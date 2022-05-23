package button_light;

public class Test {
	public static void main(String[] args) {
		Light l = new Light();
		LightAdapter la = new LightAdapter(l);
		Button b = new Button(la);
		b.press();
		b.turnOff();
//		System.out.println(l.isOn());
	}
}
