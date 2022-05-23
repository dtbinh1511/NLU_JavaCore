package ManagementSculpture;

public class Sculpture extends ArtObject {
	private String materialFrom;
	private double height;
	private double weight;

	public Sculpture(String title, String artist, int year, String description, String materialFrom, double height,
			double weight) {
		super(title, artist, year);
		this.materialFrom = materialFrom;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return super.toString() +", "+ materialFrom +", "+ height + "m, " + weight + "kg";
	}

}
