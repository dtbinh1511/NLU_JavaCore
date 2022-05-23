package Execise3;

public class Restaurant {
	private String name;
	private String food;
	private String priceRange;
	private Intersection intersection;

	public Restaurant(String name, String food, String priceRange, Intersection intersection) {
		super();
		this.name = name;
		this.food = food;
		this.priceRange = priceRange;
		this.intersection = intersection;
	}

	// tinh xem 2 nha hang co gan nhau khong
	public boolean closeTo(Restaurant orther) {
		return this.intersection.closeTo(orther.intersection);
	}
}
