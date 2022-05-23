package Bai15;

public class Sculpture extends ArtObject {
	public String materialFrom;
	public double height;
	public double weight;

	public Sculpture(String artist, String title, String description, int year, String materialFrom, double height,
			double weight) {
		super(artist, title, description, year);
		this.materialFrom = materialFrom;
		this.height = height;
		this.weight = weight;
	}

	public String getMaterialFrom() {
		return materialFrom;
	}

	public void setMaterialFrom(String materialFrom) {
		this.materialFrom = materialFrom;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
