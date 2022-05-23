package ManagementSculpture;

public class ArtObject {
	private String title;
	private String artist;
	private int year;
	private String description;

	public ArtObject(String title, String artist, int year) {
		super();
		this.title = title;
		this.artist = artist;
		this.year = year;
	}

	public ArtObject() {
	}

	@Override
	public String toString() {
		return title + ", " + artist + ", " + year;
	}

	public String getTitle() {
		return title;
	}

}
