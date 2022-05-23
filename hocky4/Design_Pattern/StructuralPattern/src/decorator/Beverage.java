package decorator;

public abstract class Beverage {
	public String description = "unknow";

	public abstract double cost();

	public String getDescription() {
		return description;
	}


}
