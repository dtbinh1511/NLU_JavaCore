package ManagementSculpture;

public class Painting extends ArtObject {
	private String paintType;
	private String style;

	public Painting(String title, String artist, int year, String description, String paintType, String style) {
		super(title, artist, year);
		this.paintType = paintType;
		this.style = style;
	}

}
