package NK1;

public class Restaurant {
	private String name;
	private String food;
	private Intersection intersection;

	public Restaurant(String name, String food, Intersection intersection) {
		super();
		this.name = name;
		this.food = food;
		this.intersection = intersection;

	}

// Kiểm tra xem hai nhà hàng có gần nhau không?
	public boolean closeTo(Restaurant other) {
		return this.intersection.closeTo(intersection);
	}
}