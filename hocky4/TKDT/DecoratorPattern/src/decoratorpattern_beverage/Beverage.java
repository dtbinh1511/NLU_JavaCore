package decoratorpattern_beverage;

public abstract class Beverage {
	protected String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	
	public abstract float cost();
}
