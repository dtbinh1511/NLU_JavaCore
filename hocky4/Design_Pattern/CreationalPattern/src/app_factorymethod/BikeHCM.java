package app_factorymethod;

public class BikeHCM extends Vehicle{
	public BikeHCM() {
		name = "Xe dap o hcm";
	}
	
	@Override
	public void refueling() {
		System.out.println("Dang tra dau vao xich");
	}
}
