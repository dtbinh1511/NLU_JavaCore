package DeThi;

public class Sculpture extends ArtObject {
	private String materialFrom;
	private double height;
	private int weight;



	public Sculpture(String title, String artist, int year, String description, String materialFrom, double height,
			int weight) {
		super(title, artist, year, description);
		this.materialFrom = materialFrom;
		this.height = height;
		this.weight = weight;
	}

	
	@Override
	public String toString() {
		return super.toString()+" materialFrom: " + materialFrom + ", height =" + height + "m, weight =" + weight + " kg"+"\n";
	}

	
}
